package semeval2013.task7.baseline;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.ExternalResource;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2013.task7.Common.Labels2way;
import semeval2013.task7.type.GoldAssessmentResult;
import semeval2013.task7.type.ReferenceAnswer;
import semeval2013.task7.type.StudentAnswer;
import dkpro.similarity.algorithms.api.SimilarityException;
import dkpro.similarity.algorithms.api.TextSimilarityMeasure;

public class SimpleTextSimilarityBaseline
    extends JCasAnnotator_ImplBase
{

    public final static String SR_RESOURCE = "SemanticRelatednessResource";
    @ExternalResource(key = SR_RESOURCE)
    protected TextSimilarityMeasure measure;

    public static final String PARAM_SIMILARITY_THRESHOLD = "SimilarityThreshold";
    @ConfigurationParameter(name = PARAM_SIMILARITY_THRESHOLD, mandatory=true)
    protected float similarityThreshold;
    
    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        List<String> referenceAnswers = new ArrayList<String>();
        for (ReferenceAnswer referenceAnswer : JCasUtil.select(jcas, ReferenceAnswer.class)) {
            referenceAnswers.add(referenceAnswer.getCoveredText());
        }

        for (StudentAnswer studentAnswer : JCasUtil.select(jcas, StudentAnswer.class)) {
            
            String studentText = studentAnswer.getCoveredText();
            
            // compare to each reference answer
            double similaritySum = 0.0;
            for (String referenceText : referenceAnswers) {
                try {
                    similaritySum += measure.getSimilarity(referenceText, studentText);
                }
                catch (SimilarityException e) {
                    throw new AnalysisEngineProcessException(e);
                }
            }
            double similarity = similaritySum / referenceAnswers.size();
            
            String result;
            if (similarity > similarityThreshold) {
                result = Labels2way.correct.name();
            }
            else {
                result = Labels2way.incorrect.name();
            }
            
            GoldAssessmentResult goldAnno = new GoldAssessmentResult(jcas, studentAnswer.getBegin(), studentAnswer.getEnd());
            goldAnno.setResult(result);
            goldAnno.addToIndexes();
        }
    }
}