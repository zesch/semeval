package semeval2013.task7;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.ExternalResourceFactory;
import org.apache.uima.resource.ExternalResourceDescription;
import org.apache.uima.resource.ResourceInitializationException;

import semeval2013.task7.Common.TaskFormat;
import semeval2013.task7.report.SimpleOverviewReport;
import semeval2013.task7.task.AlwaysCorrectBaselineTask;
import semeval2013.task7.task.RandomBaselineTask;
import semeval2013.task7.task.SimpleUnsupervisedTask;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.lab.Lab;
import de.tudarmstadt.ukp.dkpro.lab.task.Dimension;
import de.tudarmstadt.ukp.dkpro.lab.task.ParameterSpace;
import de.tudarmstadt.ukp.dkpro.lab.task.impl.BatchTask;
import de.tudarmstadt.ukp.dkpro.lab.task.impl.BatchTask.ExecutionPolicy;
import de.tudarmstadt.ukp.dkpro.lab.task.impl.TaskBase;
import dkpro.similarity.algorithms.lexical.uima.string.GreedyStringTilingMeasureResource;

public class BeetleBaselines
{

    public static final String LANGUAGE = "en";
    
    // for unsupervised
//    public static final Float[] thresholds = new Float[] {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
    public static final Float[] thresholds = new Float[] {0.5f};

    public static final Boolean[] toLowerCase = new Boolean[] { true };

    public static final String stopwordList = "classpath:/stopwords/english_stopwords.txt";
    
    public static final String SPELL_VOCABULARY = "classpath:/vocabulary/en_US_dict.txt";
            
    public static void main(String[] args)
        throws Exception
    {

        runRandomBaseline(
                TaskFormat.twoWay,
                new ParameterSpace(
                        Dimension.create("dataset", new String[]{"/beetle/twoWay/"})
                )
        );
        runRandomBaseline(
                TaskFormat.threeWay,
                new ParameterSpace(
                        Dimension.create("dataset", new String[]{"/beetle/threeWay/"})
                )
        );
        runRandomBaseline(
                TaskFormat.fiveWay,
                new ParameterSpace(
                        Dimension.create("dataset", new String[]{"/beetle/fiveWay/"})
                )
        );
        
        runAlwaysCorrectBaseline(
                TaskFormat.twoWay,
                new ParameterSpace(
                        Dimension.create("dataset", new String[]{"/beetle/twoWay/"})
                )
        );
        runAlwaysCorrectBaseline(
                TaskFormat.threeWay,
                new ParameterSpace(
                        Dimension.create("dataset", new String[]{"/beetle/threeWay/"})
                )
        );
        runAlwaysCorrectBaseline(
                TaskFormat.fiveWay,
                new ParameterSpace(
                        Dimension.create("dataset", new String[]{"/beetle/fiveWay/"})
                )
        );

        runSimpleUnsupervised(
                TaskFormat.twoWay,
                new ParameterSpace(
                        Dimension.create("dataset", new String[]{"/beetle/twoWay/"}),
                        Dimension.create("threshold", thresholds)
                ),
                ExternalResourceFactory.createExternalResourceDescription(
                        GreedyStringTilingMeasureResource.class,
                        GreedyStringTilingMeasureResource.PARAM_MIN_MATCH_LENGTH, "2"
                )
        );
    }
    
    private static void runRandomBaseline(TaskFormat taskFormat, ParameterSpace pSpace)
        throws Exception
    {
        TaskBase unsupervisedTask = new RandomBaselineTask(taskFormat);

        // Define the overall task scenario
        BatchTask batch = new BatchTask();
        batch.setType("SemEval2013Task7RandomBaseline");
        batch.setParameterSpace(pSpace);
        batch.addTask(unsupervisedTask);
        batch.setExecutionPolicy(ExecutionPolicy.RUN_AGAIN);
        batch.addReport(SimpleOverviewReport.class);

        // Run
        Lab.getInstance().run(batch);
//        Lab.newInstance("/lab/debug_context.xml").run(batch);   
    }

    private static void runAlwaysCorrectBaseline(TaskFormat taskFormat, ParameterSpace pSpace)
        throws Exception
    {
        TaskBase unsupervisedTask = new AlwaysCorrectBaselineTask(taskFormat);

        // Define the overall task scenario
        BatchTask batch = new BatchTask();
        batch.setType("SemEval2013Task7AlwaysCorrectBaseline");
        batch.setParameterSpace(pSpace);
        batch.addTask(unsupervisedTask);
        batch.setExecutionPolicy(ExecutionPolicy.RUN_AGAIN);
        batch.addReport(SimpleOverviewReport.class);

        // Run
        Lab.getInstance().run(batch);
//            Lab.newInstance("/lab/debug_context.xml").run(batch);   
    }

    private static void runSimpleUnsupervised(TaskFormat taskFormat, ParameterSpace pSpace, ExternalResourceDescription externalResource)
        throws Exception
    {
        TaskBase unsupervisedTask = new SimpleUnsupervisedTask(taskFormat, externalResource);

        // Define the overall task scenario
        BatchTask batch = new BatchTask();
        batch.setType("SemEval2013Task7SimpleSupervised");
        batch.setParameterSpace(pSpace);
        batch.addTask(unsupervisedTask);
        batch.setExecutionPolicy(ExecutionPolicy.RUN_AGAIN);
        batch.addReport(SimpleOverviewReport.class);

        // Run
        Lab.getInstance().run(batch);
//        Lab.newInstance("/lab/debug_context.xml").run(batch);   
    }

    public static AnalysisEngineDescription getPreprocessing()
            throws ResourceInitializationException
    {
        
        return createEngineDescription(
                createEngineDescription(
                        BreakIteratorSegmenter.class
                )
//                ),                
//                createEngineDescription(
//                        SpellChecker.class,
//                        SpellChecker.PARAM_MODEL_LOCATION, SPELL_VOCABULARY
//                ),
//                createEngineDescription(
//                        OpenNlpPosTagger.class
//                ),
//                createEngineDescription(
//                        StanfordParser.class,
//                        StanfordParser.PARAM_VARIANT,"pcfg"
//                )
        );
    }
}