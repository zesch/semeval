package semeval2014.task9.io;

import static org.junit.Assert.assertEquals;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

public class TaskBReaderTest
{
    @Test
    public void combinationReaderTest() throws Exception {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                TaskBSemevalTwitterCorpusReader.class,
                TaskBSemevalTwitterCorpusReader.PARAM_SOURCE_LOCATION, "classpath:/test/twitter/subtask_b_test.tweets"
        );
        
        int i = 0;
        for (JCas jcas : new JCasIterable(reader)) {
            System.out.println(jcas.getDocumentText());
            i++;
        }
        
        assertEquals(4, i);
    }
}