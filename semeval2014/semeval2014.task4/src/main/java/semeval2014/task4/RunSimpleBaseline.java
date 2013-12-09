package semeval2014.task4;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2014.task4.io.Task4Reader;
import semeval2014.task4.type.AspectCategory;
import semeval2014.task4.type.AspectTerm;

public class RunSimpleBaseline
{
    public static void main(String[] args)
        throws Exception
    {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Task4Reader.class,
                Task4Reader.PARAM_INPUT_FILE, "classpath:/trial/restaurants-trial.xml"
        );
        
        int termsCorrect = 0;
        int nrOfTerms = 0;
        
        int categoriesCorrect = 0;
        int nrOfCategories = 0;
        
        // iterate over all sentences
        for (JCas jcas : new JCasIterable(reader)) {
            
            System.out.println(jcas.getDocumentText());
            
            // get the terms
            for (AspectTerm term : JCasUtil.select(jcas, AspectTerm.class)) {
                if (term.getPolarity().equals("positive")) {
                    termsCorrect++;
                }
                nrOfTerms++;
            }
            
            for (AspectCategory category : JCasUtil.select(jcas, AspectCategory.class)) {
                if (category.getPolarity().equals("positive")) {
                    categoriesCorrect++;
                }
                nrOfCategories++;
            }
        }
        
        System.out.println("Accuracy term polarity: " + (double) termsCorrect / nrOfTerms);
        System.out.println("Accuracy category polarity: " + (double) categoriesCorrect / nrOfCategories); 
    }
}
