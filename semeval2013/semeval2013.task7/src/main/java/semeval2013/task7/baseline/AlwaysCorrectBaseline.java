package semeval2013.task7.baseline;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2013.task7.Common.Labels2way;
import semeval2013.task7.Common.TaskFormat;
import semeval2013.task7.type.GoldAssessmentResult;
import semeval2013.task7.type.StudentAnswer;

public class AlwaysCorrectBaseline
    extends JCasAnnotator_ImplBase
{

    public static final String PARAM_TASK_FORMAT = "TaskFormat";
    @ConfigurationParameter(name = PARAM_TASK_FORMAT, mandatory = true)
    protected TaskFormat taskFormat;
    
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        for (StudentAnswer studentAnswer : JCasUtil.select(jcas, StudentAnswer.class)) {
            GoldAssessmentResult result = new GoldAssessmentResult(jcas, studentAnswer.getBegin(), studentAnswer.getEnd());
            result.setResult(Labels2way.correct.name());
            result.addToIndexes();
        }
    }
}