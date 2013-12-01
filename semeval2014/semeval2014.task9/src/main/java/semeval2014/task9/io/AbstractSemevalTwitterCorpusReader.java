package semeval2014.task9.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.parameter.ComponentParameters;
import de.tudarmstadt.ukp.dkpro.core.api.resources.ResourceUtils;
import de.tudarmstadt.ukp.dkpro.tc.io.TCReaderSingleLabel;

/**
 * SemEval 2014 - Task 9
 * Baseclass for Subtask A & Subtask B readers
 * 
 * @author daxenberger
 * @author ferschke
 * @author flekova
 *
 */
public abstract class AbstractSemevalTwitterCorpusReader
	extends JCasCollectionReader_ImplBase
    implements TCReaderSingleLabel
{
    protected final String separator = "\t";
	
	/**
     * Location of corpus file
     */
    public static final String PARAM_SOURCE_LOCATION = ComponentParameters.PARAM_SOURCE_LOCATION;
    @ConfigurationParameter(name = PARAM_SOURCE_LOCATION, mandatory = true)
    protected String corpusFile;
    
    public static final String PARAM_LANGUAGE = ComponentParameters.PARAM_LANGUAGE;
    @ConfigurationParameter(name = PARAM_LANGUAGE, mandatory = true, defaultValue="en")
    protected String language;

    protected List<String> rawTweets;

    protected int currentIndex;
    
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
    	super.initialize(context);

        // read corpus into list (each line one item)
        // further processing will be done in the dedicated TaskA/B readers
    	try {
            URL url = ResourceUtils.resolveLocation(corpusFile, null);
            InputStream is = url.openStream();
            rawTweets = IOUtils.readLines(is, "UTF-8");
    	}
    	catch(IOException e) {
            throw new ResourceInitializationException(new Throwable("Could not read corpus: " + corpusFile));
    	}
    }
 
	public String getTextClassificationOutcome(JCas jcas)
			throws CollectionException {
		// we directly determine the outcomes in the getNext() methods of both task-readers; 
		return null;
	}
    
    /**
     * Includes preprocessing that should be done *BEFORE* the cas text is set.
     * May be left empty. Should be limited to the minimum, e.g. replacing URLs with some label
     * Most preprocessing should be done later as annotations.
     * 
     * NOTE: If any whitespaces are removed or added, the start/end tokens in Task A will no longer match
     * 
     * @param tweet the tweet text
     * @return the preprocessed tweet text
     */
    protected String preprocessTweet(String tweet){
    	
    	String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
    	tweet.replaceAll(regex, "hyperlink");    	
    	
    	return tweet;
    }
}