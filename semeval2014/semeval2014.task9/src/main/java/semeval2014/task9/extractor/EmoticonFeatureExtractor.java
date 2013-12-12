package semeval2014.task9.extractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.uima.fit.descriptor.TypeCapability;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.tc.api.features.ClassificationUnitFeatureExtractor;
import de.tudarmstadt.ukp.dkpro.tc.api.features.Feature;
import de.tudarmstadt.ukp.dkpro.tc.api.features.FeatureExtractorResource_ImplBase;
import de.tudarmstadt.ukp.dkpro.tc.exception.TextClassificationException;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationUnit;

/**
 * Adds to binary features:
 * whether a tweet contains a positive emoticon and whether it contains a negative emoticon
 * 
 * This is only a proof-of-concept feature extractor :)
 * 
 * @author zesch
 *
 */
@TypeCapability(inputs = { "de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence",
        "de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token" })
public class EmoticonFeatureExtractor
    extends FeatureExtractorResource_ImplBase
    implements ClassificationUnitFeatureExtractor
{

    public static final String FN_EMOTICON_POS = "ContainsPositiveEmoticon";
    public static final String FN_EMOTICON_NEG = "ContainsNegativeEmoticon";
    
    public List<Feature> extract(JCas jcas, TextClassificationUnit classificationUnit)
        throws TextClassificationException
    {
        List<Feature> featList = new ArrayList<Feature>();
        
        String tweetText = jcas.getDocumentText();
        boolean containsPos = tweetText.contains(":)") || tweetText.contains(":-)");
        boolean containsNeg = tweetText.contains(":(") || tweetText.contains(":-(");
 
        if (containsPos) {
            featList.addAll(Arrays.asList(new Feature(FN_EMOTICON_POS, 1)));
        }
        else {
            featList.addAll(Arrays.asList(new Feature(FN_EMOTICON_POS, 0)));
        }
        
        if (containsNeg) {
            featList.addAll(Arrays.asList(new Feature(FN_EMOTICON_NEG, 1)));
        }
        else {
            featList.addAll(Arrays.asList(new Feature(FN_EMOTICON_NEG, 0)));
        }

        return featList;
    }
}
