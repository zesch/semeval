package semeval2013.task6;

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
import de.tudarmstadt.ukp.dkpro.tc.weka.report.BatchOutcomeIDReport;
import de.tudarmstadt.ukp.dkpro.tc.weka.report.BatchTrainTestReport;
import de.tudarmstadt.ukp.dkpro.tc.weka.report.RegressionReport;
import de.tudarmstadt.ukp.dkpro.tc.weka.task.BatchTaskCrossValidation;
import de.tudarmstadt.ukp.dkpro.tc.weka.task.BatchTaskTrainTest;
import de.tudarmstadt.ukp.dkpro.tc.weka.writer.WekaDataWriter;

public class RunExperimentDKproTC
{
    public static final String LANGUAGE_CODE = "en";
    public static int NUM_FOLDS = 2;
 
    // train
    public static final String[] inputFilesTrain = new String[] {
        "src/main/resources/core/train/STS.input.MSRpar.txt",
        "src/main/resources/core/train/STS.input.MSRvid.txt",
        "src/main/resources/core/train/STS.input.SMTeuroparl.txt"
    };
    
    public static final String[] goldFilesTrain = new String[] {
        "src/main/resources/core/train/STS.gs.MSRpar.txt",
        "src/main/resources/core/train/STS.gs.MSRvid.txt",
        "src/main/resources/core/train/STS.gs.SMTeuroparl.txt"
    };
    
    // test
    public static final String[] inputFilesTest = new String[] {
        "src/main/resources/core/test/STS.input.FNWN.txt",
        "src/main/resources/core/test/STS.input.headlines.txt",
        "src/main/resources/core/test/STS.input.OnWN.txt"
    };
    
    public static final String[] goldFilesTest = new String[] {
        "src/main/resources/core/test/STS.gs.FNWN.txt",
        "src/main/resources/core/test/STS.gs.headlines.txt",
        "src/main/resources/core/test/STS.gs.OnWN.txt"
    };
    
    public static void main(String[] args)
        throws Exception
    {
        RunExperimentDKproTC experiment = new RunExperimentDKproTC();
        experiment.runCrossValidation(setup());
        experiment.runTrainTest(setup());
    }

    public static ParameterSpace setup()
    {
        // configure training data reader dimension
        Map<String, Object> dimReaders = new HashMap<String, Object>();
        dimReaders.put(Constants.DIM_READER_TRAIN, STSReader.class);
        dimReaders.put(Constants.DIM_READER_TRAIN_PARAMS,
                Arrays.asList(new Object[] {
                        STSReader.PARAM_INPUT_FILES, inputFilesTrain,
                        STSReader.PARAM_GOLD_FILES, goldFilesTrain
                }));
        dimReaders.put(Constants.DIM_READER_TEST, STSReader.class);
        dimReaders.put(Constants.DIM_READER_TEST_PARAMS,
                Arrays.asList(new Object[] {
                        STSReader.PARAM_INPUT_FILES, inputFilesTest,
                        STSReader.PARAM_GOLD_FILES, goldFilesTest
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
                Dimension.createBundle("readerTrain",dimReaders),
                Dimension.create(Constants.DIM_MULTI_LABEL, false),
                Dimension.create(Constants.DIM_IS_REGRESSION, true),
                Dimension.create(Constants.DIM_DATA_WRITER, WekaDataWriter.class.getName()),
                dimFeatureSets,
                dimClassificationArgs
        );
        return pSpace;
    }
    
    public static ParameterSpace setupCV()
    {
        // configure training data reader dimension
        Map<String, Object> dimReaderTrain = new HashMap<String, Object>();
        dimReaderTrain.put(Constants.DIM_READER_TRAIN, STSReader.class);
        dimReaderTrain.put(Constants.DIM_READER_TRAIN_PARAMS,
                Arrays.asList(new Object[] {
                        STSReader.PARAM_INPUT_FILES, inputFilesTrain,
                        STSReader.PARAM_GOLD_FILES, goldFilesTrain
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
                "STS-2012-Task6-CV",
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

    // ##### TRAIN-TEST #####
    protected void runTrainTest(ParameterSpace pSpace)
        throws Exception
    {

        BatchTaskTrainTest batch = new BatchTaskTrainTest(
                "STS-2012-Task6-TrainTest",
                getPreprocessing()
        );
        batch.setInnerReport(RegressionReport.class);
        batch.setParameterSpace(pSpace);
        batch.setExecutionPolicy(ExecutionPolicy.RUN_AGAIN);
        batch.addReport(BatchTrainTestReport.class);
        batch.addReport(BatchOutcomeIDReport.class);

        // Run
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