package semeval2014.task9.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;

/**
 * SemEval 2014 - Task 9 - Subtask A Reader
 * 
 * @author daxenberger
 * @author ferschke
 * @author flekova
 *
 */
public class TaskASemevalTwitterCorpusReader
    extends AbstractSemevalTwitterCorpusReader
{    
	// item list one entry for each tweet. each entry contains all sentiments for the tweet 
	List<String[]> items; 
	
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
    	super.initialize(context);

    	items= new ArrayList<String[]>();

        for (String line : rawTweets) {          
            String[] item = line.split(separator); 
            if(item.length!=6){
            	throw new ResourceInitializationException("Parsing error. Line must have 6 segments. Tweet might contain segment separator.", item);
            }
            items.add(item);
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
        // <SID><TWEETID><START><END><SENTIMENT><TWITTER_MESSAGE>
		String[] item = items.get(currentIndex);
		
		String sid = item[0];
		String tweetid = item[1];
		int startToken = Integer.parseInt(item[2]);
        int endToken = Integer.parseInt(item[3]);
        String outcomeString = item[4];
		String text = preprocessTweet(item[5]); //NOTE: preprocessing should not alter the number of whitespaces or the spans won't match
        		
		jCas.setDocumentLanguage(language);
        jCas.setDocumentText(text); 

        DocumentMetaData dmd = DocumentMetaData.create(jCas);
		dmd.setDocumentId(sid); 
		dmd.setDocumentTitle(new Integer(currentIndex).toString());
		dmd.setDocumentUri(tweetid+"#"+sid); //URI should be unique
		dmd.setCollectionId(corpusFile);
        
        TextClassificationOutcome outcome = new TextClassificationOutcome(jCas);
        outcomeString = outcomeString.toLowerCase().replace("\"", "").trim();
        
        //treat neutral and objective the same way
        if (!(outcomeString.equals("positive") | outcomeString.equals("negative"))) 
        {
            outcomeString = "neutral";        	
        }
        outcome.setOutcome(outcomeString);                
        
        //the tokenStart and tokenEnd in the corpus refer to simple whitespace splits.
        //we iterate once over all chars in the text to identify the location of the whitespaces before/adter the start/end token
        char[] chars = (text+" ").toCharArray(); //trailing dummy whitespace necessary if endToken is last token
        int begin=-1, end = -1, whitespace=0;
        try{
            for (int i = 0; i < chars.length; i++) {
            	if(chars[i]==' '){whitespace++;}
            	begin=begin<0&&whitespace==startToken?i:begin;
            	end=end<0&&whitespace==endToken+1?i:end;
           	}        	
        }catch(StringIndexOutOfBoundsException e){
			throw new CollectionException("Segmentation error. Invalid token span: "+startToken+","+endToken, null, e);
        }
        
        outcome.setBegin(begin);
        outcome.setEnd(end);        
        outcome.addToIndexes();
		
        currentIndex++; 		
	}

}
