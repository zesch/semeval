package semeval2013.task7;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2013.task7.Common.Labels2way;
import semeval2013.task7.io.SemEval2013Task7Reader;
import semeval2013.task7.type.StudentAnswer;

public class SimpleBaseline
{

    public static void main(String[] args)
        throws Exception
    {
        String path = "src/main/resources/train/beetle/twoWay/";

        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                SemEval2013Task7Reader.class, 
                SemEval2013Task7Reader.PARAM_SOURCE_LOCATION, path, 
                SemEval2013Task7Reader.PARAM_PATTERNS, new String[] {
                    SemEval2013Task7Reader.INCLUDE_PREFIX + "*.xml"
                }
        );
        
        int correct = 0;
        int wrong = 0;
        
        for (JCas jcas : new JCasIterable(reader)) {
            for (StudentAnswer studentAnswer : JCasUtil.select(jcas,  StudentAnswer.class)) {
                
                String gold = studentAnswer.getLabel();
                String computed = Labels2way.correct.name();

                System.out.println(gold + " - " + computed);
            
                if (gold.equals(computed)) {
                    correct++;
                }
                else {
                    wrong++;
                }        
            }
        }
        
        System.out.println("Accuracy: " + (double) correct / (correct + wrong));
    }
}
