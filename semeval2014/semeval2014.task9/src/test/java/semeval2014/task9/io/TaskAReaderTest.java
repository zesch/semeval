package semeval2014.task9.io;

import static org.junit.Assert.assertEquals;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;

public class TaskAReaderTest
{
    @Test
    public void combinationReaderTest() throws Exception {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                TaskASemevalTwitterCorpusReader.class,
                TaskASemevalTwitterCorpusReader.PARAM_SOURCE_LOCATION, "classpath:/test/twitter/subtask_a_test.tweets"
        );
        
        int i = 0;
        for (JCas jcas : new JCasIterable(reader)) {
            for (TextClassificationOutcome outcome : JCasUtil.select(jcas, TextClassificationOutcome.class)) {
                System.out.println(outcome.getCoveredText() + " - " + outcome.getOutcome());
            }
            i++;
        }
        
        assertEquals(8, i);
    }
}