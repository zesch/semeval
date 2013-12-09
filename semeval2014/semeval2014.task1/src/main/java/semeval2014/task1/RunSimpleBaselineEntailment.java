package semeval2014.task1;

import java.util.ArrayList;
import java.util.List;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2014.task1.io.SickReader;
import semeval2014.task1.io.SickReader.Mode;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;

public class RunSimpleBaselineEntailment
{
    public static final String LANGUAGE_CODE = "es";
    public static final String inputFile = "src/main/resources/trial/SICK_trial.txt";

    public static void main(String[] args)
        throws Exception
    {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                SickReader.class,
                SickReader.PARAM_INPUT_FILE, inputFile,
                SickReader.PARAM_MODE, Mode.entailment
        );
        
        List<String> computedValues = new ArrayList<String>();
        List<String> goldValues = new ArrayList<String>();

        // iterate over all text pairs
        for (JCas jcas : new JCasIterable(reader)) {
            
            String text1 = jcas.getView(SickReader.PART_ONE).getDocumentText();
            String text2 = jcas.getView(SickReader.PART_TWO).getDocumentText();

            // get the gold annotation value
            TextClassificationOutcome outcome = JCasUtil.selectSingle(jcas, TextClassificationOutcome.class);
            goldValues.add(outcome.getOutcome());
            
            // always "NEUTRAL" baseline
            computedValues.add("NEUTRAL");      
        }
        
        int correct = 0;
        for (int i=0; i<computedValues.size(); i++) {
            String computed = computedValues.get(i);
            String gold = goldValues.get(i);
            
            if (computed.equals(gold)) {
                correct++;
            }
        }
        
        System.out.println("Accuracy: " + (double) correct / computedValues.size());
    }
}