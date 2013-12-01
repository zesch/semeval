package semeval2014.task9;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2014.task9.io.TaskBSemevalTwitterCorpusReader;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;

public class SubtaskB_SimpleBaseline
{

    public static void main(String[] args)
        throws Exception
    {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                TaskBSemevalTwitterCorpusReader.class,
                TaskBSemevalTwitterCorpusReader.PARAM_SOURCE_LOCATION, "classpath:/twitter/tweeti-b.dist.tweets"
        );
        
        int correct = 0;
        int n = 0;
        
        // iterate over all tweets
        for (JCas jcas : new JCasIterable(reader)) {
            
            // get the gold annotation value
            TextClassificationOutcome outcome = JCasUtil.selectSingle(jcas, TextClassificationOutcome.class);
            
            // if you want to do something real, you can access the actual tweet like that 
//             jcas.getDocumentText();
            
            // we use a baseline that counts as correct if sentiment is "neutral"
            // you can add your decision method here instead
            if (outcome.getOutcome().equals("neutral")) {
                correct++;
            }
            n++;
        }
        
        System.out.println("Accuracy: " + (double) correct / n);
    }
}