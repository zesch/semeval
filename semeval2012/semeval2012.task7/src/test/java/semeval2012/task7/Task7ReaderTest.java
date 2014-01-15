package semeval2012.task7;

import static org.junit.Assert.assertEquals;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import semeval2012.task7.io.Task7Reader;
import semeval2012.task7.type.Alternative;
import semeval2012.task7.type.Statement;

public class Task7ReaderTest
{

    @Test
    public void task4ReaderTest() 
        throws Exception
    {   
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Task7Reader.class,
                Task7Reader.PARAM_INPUT_FILE, "src/main/resources/copa/copa-dev.xml"
        );

        int i=0;
        for (JCas jcas : new JCasIterable(reader)) {
            if (i==0) {
                System.out.println(jcas.getDocumentText());

                Statement statement = JCasUtil.selectSingle(jcas, Statement.class);
                assertEquals("1", statement.getId());
                assertEquals("cause", statement.getAsksFor());
                assertEquals("1", statement.getMostPlausibleAlternative());
                assertEquals("My body cast a shadow over the grass.", statement.getCoveredText());

                              
                for (Alternative alternative : JCasUtil.select(jcas, Alternative.class)) {
                    if (alternative.getOffset() == "1") {
                        assertEquals("The sun was rising.", alternative.getCoveredText());
                    }
                    else {
                        assertEquals("The grass was cut.", alternative.getCoveredText());
                    }
                }
            }
            
            i++;
        }
        assertEquals(500, i);
    }
}
