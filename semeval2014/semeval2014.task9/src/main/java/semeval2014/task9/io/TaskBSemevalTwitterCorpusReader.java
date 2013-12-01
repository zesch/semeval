package semeval2014.task9.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;

/**
 * SemEval 2014 - Task 9 - Subtask B Reader
 * 
 * @author daxenberger
 * @author ferschke
 * @author flekova
 *
 */
public class TaskBSemevalTwitterCorpusReader
    extends AbstractSemevalTwitterCorpusReader
{	  
    List<String[]> items; 
    
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
    	super.initialize(context);
    	//TODO parse rawTweets (created by abstract reader)
    	
    	items = new ArrayList<String[]>();

        for (String line : rawTweets) {
            String[] nextItem = line.split(separator); 
            if (nextItem.length !=4 ) {
                //TODO OF: This is just to make sure that the \t split is correct. theoretically, a tweet could contain a \t character. This will probably never happen.
            	throw new ResourceInitializationException(
            	    new Throwable("Parsing error. Line must have 4 segments. Tweet might contain segment separator: " + StringUtils.join(nextItem, " "))
            	);
            }
          
            items.add(nextItem);
        }
        
        currentIndex = 0;
    }

	public Progress[] getProgress() {
        return new Progress[] { new ProgressImpl(currentIndex, items.size(), Progress.ENTITIES) };
	}

	public boolean hasNext() throws IOException, CollectionException {
        return currentIndex < items.size();
	}

	@Override
	public void getNext(JCas jCas) throws IOException, CollectionException {

		String[] item = items.get(currentIndex);
        jCas.setDocumentLanguage(language);
        jCas.setDocumentText(preprocessTweet(item[3]));

        DocumentMetaData dmd = DocumentMetaData.create(jCas);
		dmd.setDocumentId(item[0]); //this one or the item[0]? OF: doesn't matter for task b
		dmd.setDocumentTitle(new Integer(currentIndex).toString());
		dmd.setDocumentUri(item[1]+"#"+item[0]); //URI should be unique
		dmd.setCollectionId(corpusFile);
			
        TextClassificationOutcome outcome = new TextClassificationOutcome(jCas);
        String outcomeString = item[2];
        outcomeString = outcomeString.toLowerCase().replace("\"", "").trim();
        //treat neutral and objective the same way
        if (!(outcomeString.equals("positive") | outcomeString.equals("negative"))) 
        {
            outcomeString = "neutral";        	
        }
        outcome.setOutcome(outcomeString);
        outcome.addToIndexes();
        
        currentIndex++;
	}
}