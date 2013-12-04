package semeval2014.task10;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.resource.ResourceInitializationException;

import semeval2014.task10.io.STSReader;
import weka.classifiers.functions.SMOreg;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.lab.Lab;
import de.tudarmstadt.ukp.dkpro.lab.task.Dimension;
import de.tudarmstadt.ukp.dkpro.lab.task.ParameterSpace;
import de.tudarmstadt.ukp.dkpro.lab.task.impl.BatchTask.ExecutionPolicy;
import de.tudarmstadt.ukp.dkpro.tc.core.Constants;
import de.tudarmstadt.ukp.dkpro.tc.features.length.NrOfTokensFeatureExtractor;
import de.tudarmstadt.ukp.dkpro.tc.features.pair.similarity.GreedyStringTilingFeatureExtractor;
import de.tudarmstadt.ukp.dkpro.tc.weka.report.BatchCrossValidationReport;
import de.tudarmstadt.ukp.dkpro.tc.weka.report.RegressionReport;
import de.tudarmstadt.ukp.dkpro.tc.weka.task.BatchTaskCrossValidation;
import de.tudarmstadt.ukp.dkpro.tc.weka.writer.WekaDataWriter;

public class RunExperimentDKproTC
{
    public static final String LANGUAGE_CODE = "es";
    public static int NUM_FOLDS = 2;
    public static final String inputFile = "src/main/resources/STS-Es-trial/sts.input.li65.txt";
    public static final String goldFile = "src/main/resources/STS-Es-trial/sts.gs.li65.txt";

    public static void main(String[] args)
        throws Exception
    {
        RunExperimentDKproTC experiment = new RunExperimentDKproTC();
        experiment.runCrossValidation(setup());
    }

    public static ParameterSpace setup()
    {
        // configure training data reader dimension
        Map<String, Object> dimReaderTrain = new HashMap<String, Object>();
        dimReaderTrain.put(Constants.DIM_READER_TRAIN, STSReader.class);
        dimReaderTrain.put(Constants.DIM_READER_TRAIN_PARAMS,
                Arrays.asList(new Object[] {
                        STSReader.PARAM_INPUT_FILE, inputFile,
                        STSReader.PARAM_GOLD_FILE, goldFile
                }));

        @SuppressWarnings("unchecked")
        Dimension<List<String>> dimClassificationArgs = Dimension.create(
                Constants.DIM_CLASSIFICATION_ARGS,
                Arrays.asList(new String[] {
                        // which classifiers should be tested
                        SMOreg.class.getName()
                }));

        @SuppressWarnings("unchecked")
        Dimension<List<String>> dimFeatureSets = Dimension.create(
                Constants.DIM_FEATURE_SET,
                Arrays.asList(new String[] {
                        // which feature extractors should be used
                        NrOfTokensFeatureExtractor.class.getName(),
                        GreedyStringTilingFeatureExtractor.class.getName()
                }));

        @SuppressWarnings("unchecked")
        ParameterSpace pSpace = new ParameterSpace(
                Dimension.createBundle("readerTrain",dimReaderTrain),
                Dimension.create(Constants.DIM_MULTI_LABEL, false),
                Dimension.create(Constants.DIM_IS_REGRESSION, true),
                Dimension.create(Constants.DIM_DATA_WRITER, WekaDataWriter.class.getName()),
                dimFeatureSets,
                dimClassificationArgs
        );
        return pSpace;
    }

    // ##### CV #####
    protected void runCrossValidation(ParameterSpace pSpace)
        throws Exception
    {
        BatchTaskCrossValidation batch = new BatchTaskCrossValidation(
                "STS-ES-Example-CV",
                getPreprocessing(),
                NUM_FOLDS
        );
        batch.setParameterSpace(pSpace);
        batch.setExecutionPolicy(ExecutionPolicy.RUN_AGAIN);    // don't try to reuse runs - slower, but safer   
        batch.setInnerReport(RegressionReport.class);
        batch.addReport(BatchCrossValidationReport.class);

        // Run the configured experiment
        // Results will be stored 
        Lab.getInstance().run(batch);
    }

    public static AnalysisEngineDescription getPreprocessing()
        throws ResourceInitializationException
    {
        // which preprocessing components should be run?
        return createEngineDescription(
                createEngineDescription(BreakIteratorSegmenter.class),  // tokenizer
                createEngineDescription(OpenNlpPosTagger.class)         // POS tagger
        );
    }
}