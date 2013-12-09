package semeval2014.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2014.task1.io.SickReader;
import semeval2014.task1.io.SickReader.Mode;
import de.tudarmstadt.ukp.dkpro.statistics.correlation.PearsonCorrelation;
import de.tudarmstadt.ukp.dkpro.statistics.correlation.SpearmansRankCorrelation;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;
import dkpro.similarity.algorithms.lexical.string.GreedyStringTiling;

public class RunSimpleBaselineRelatedness
{
    public static final String LANGUAGE_CODE = "es";
    public static final String inputFile = "src/main/resources/trial/SICK_trial.txt";

    public static void main(String[] args)
        throws Exception
    {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                SickReader.class,
                SickReader.PARAM_INPUT_FILE, inputFile,
                SickReader.PARAM_MODE, Mode.relatedness
        );
        
        List<Double> computedValues = new ArrayList<Double>();
        List<Double> goldValues = new ArrayList<Double>();

        // iterate over all text pairs
        for (JCas jcas : new JCasIterable(reader)) {
            
            String text1 = jcas.getView(SickReader.PART_ONE).getDocumentText();
            String text2 = jcas.getView(SickReader.PART_TWO).getDocumentText();

            // get the gold annotation value
            TextClassificationOutcome outcome = JCasUtil.selectSingle(jcas, TextClassificationOutcome.class);
            goldValues.add(Double.parseDouble(outcome.getOutcome()));
            
            List<String> tokens1 = Arrays.asList(text1.split(" "));
            List<String> tokens2 = Arrays.asList(text2.split(" "));

            GreedyStringTiling gst = new GreedyStringTiling(3);
            double similarity = gst.getSimilarity(tokens1, tokens2);
            computedValues.add(similarity);      
        }
        
        double pearson = PearsonCorrelation.computeCorrelation(computedValues, goldValues);
        System.out.println("Correlation (Pearson): " + pearson);

        double spearman = SpearmansRankCorrelation.computeCorrelation(computedValues, goldValues);
        System.out.println("Correlation (Spearman): " + spearman); 
    }
}