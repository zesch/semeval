package semeval2013.task7.baseline;

import java.util.Random;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import semeval2013.task7.Common.Labels2way;
import semeval2013.task7.Common.Labels3way;
import semeval2013.task7.Common.Labels5way;
import semeval2013.task7.Common.TaskFormat;
import semeval2013.task7.type.GoldAssessmentResult;
import semeval2013.task7.type.StudentAnswer;

public class RandomAssessmentBaseline
    extends JCasAnnotator_ImplBase
{

    public static final String PARAM_TASK_FORMAT = "TaskFormat";
    @ConfigurationParameter(name = PARAM_TASK_FORMAT, mandatory = true)
    protected TaskFormat taskFormat;
    
    public static final String PARAM_RANDOM_SEED = "RandomSeed";
    @ConfigurationParameter(name = PARAM_RANDOM_SEED, mandatory = true, defaultValue="1234567890")
    protected long randomSeed;

    private Random random;
    
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
        random = new Random(randomSeed);
    }

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        for (StudentAnswer studentAnswer : JCasUtil.select(jcas, StudentAnswer.class)) {
            GoldAssessmentResult result = new GoldAssessmentResult(jcas, studentAnswer.getBegin(), studentAnswer.getEnd());
            result.setResult(getRandomResult());
            result.addToIndexes();
        }
    }
    
    private String getRandomResult() {
        String result;
        if (taskFormat.equals(TaskFormat.fiveWay)) {
            Labels5way[] labels = Labels5way.values();
            int randomOffset = random.nextInt(5);
            result = labels[randomOffset].name();
        }
        else if (taskFormat.equals(TaskFormat.threeWay)) {
            Labels3way[] labels = Labels3way.values();
            int randomOffset = random.nextInt(3);
            result = labels[randomOffset].name();
        }
        else if (taskFormat.equals(TaskFormat.twoWay)) {
            Labels2way[] labels = Labels2way.values();
            int randomOffset = random.nextInt(2);
            result = labels[randomOffset].name();
        }
        else {
            throw new IllegalArgumentException("Unknown task format: "  + taskFormat);
        }
        
        return result;
    }
}