package semeval2014.task4;

import static org.junit.Assert.assertEquals;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import semeval2014.task4.io.Task4Reader;
import semeval2014.task4.type.AspectCategory;
import semeval2014.task4.type.AspectTerm;

public class Task4ReaderTest
{

    @Test
    public void task4ReaderTest() 
        throws Exception
    {   
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Task4Reader.class,
                Task4Reader.PARAM_INPUT_FILE, "src/main/resources/trial/restaurants-trial.xml"
        );

        int i=0;
        for (JCas jcas : new JCasIterable(reader)) {
            if (i==0) {
                System.out.println(jcas.getDocumentText());
                int nrOfTerms = 0;
                for (AspectTerm term : JCasUtil.select(jcas, AspectTerm.class)) {
                    System.out.println(term);
                    nrOfTerms++;
                }
                assertEquals(4, nrOfTerms);
                
                int nrOfCategories = 0;
                for (AspectCategory category : JCasUtil.select(jcas, AspectCategory.class)) {
                    System.out.println(category);
                    nrOfCategories++;
                }
                assertEquals(1, nrOfCategories);
            }
            
            i++;
        }
        assertEquals(100, i);
    }
}
