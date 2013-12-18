package semeval2013.task7.task;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import java.io.IOException;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.resource.ResourceInitializationException;

import semeval2013.task7.Common.TaskFormat;
import semeval2013.task7.baseline.AlwaysCorrectBaseline;
import semeval2013.task7.io.SemEval2013Task7Evaluator;
import de.tudarmstadt.ukp.dkpro.lab.engine.TaskContext;
import de.tudarmstadt.ukp.dkpro.lab.storage.StorageService.AccessMode;

public class AlwaysCorrectBaselineTask
    extends SemEval2013TaskBase
{

    private TaskFormat taskFormat;
    
    public AlwaysCorrectBaselineTask(TaskFormat taskFormat)
    {
        this.taskFormat = taskFormat;
    }

    public AnalysisEngineDescription getAnalysisEngineDescription(TaskContext aContext)
        throws ResourceInitializationException, IOException
    {

        String resultsPath = aContext.getStorageLocation(RESULTS_FOLDER, AccessMode.READWRITE).getAbsolutePath();
        
        return createEngineDescription(
                createEngineDescription(
                        AlwaysCorrectBaseline.class,
                        AlwaysCorrectBaseline.PARAM_TASK_FORMAT, taskFormat
                ),
                createEngineDescription(
                        SemEval2013Task7Evaluator.class,
                        SemEval2013Task7Evaluator.PARAM_TASK_FORMAT, taskFormat,
                        SemEval2013Task7Evaluator.PARAM_RESULTS_FILE, resultsPath + "/" + RESULTS_FILE)
        );
    }
}