package semeval2013.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2014.task10.io.STSReader;
import de.tudarmstadt.ukp.dkpro.statistics.correlation.PearsonCorrelation;
import de.tudarmstadt.ukp.dkpro.statistics.correlation.SpearmansRankCorrelation;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;
import dkpro.similarity.algorithms.lexical.string.GreedyStringTiling;

public class RunSimpleBaseline
{
    public static final String LANGUAGE_CODE = "en";
    
    // test
    public static final String[] inputFiles = new String[] {
        "src/main/resources/core/test/STS.input.FNWN.txt",
        "src/main/resources/core/test/STS.input.headlines.txt",
        "src/main/resources/core/test/STS.input.OnWN.txt"
    };
    
    public static final String[] goldFiles = new String[] {
        "src/main/resources/core/test/STS.gs.FNWN.txt",
        "src/main/resources/core/test/STS.gs.headlines.txt",
        "src/main/resources/core/test/STS.gs.OnWN.txt"
    };
        
    public static void main(String[] args)
        throws Exception
    {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                STSReader.class,
                STSReader.PARAM_INPUT_FILES, inputFiles,
                STSReader.PARAM_GOLD_FILES, goldFiles
        );
        
        List<Double> computedValues = new ArrayList<Double>();
        List<Double> goldValues = new ArrayList<Double>();

        // iterate over all text pairs
        for (JCas jcas : new JCasIterable(reader)) {
            
            String text1 = jcas.getView(STSReader.PART_ONE).getDocumentText();
            String text2 = jcas.getView(STSReader.PART_TWO).getDocumentText();

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