package semeval2014.task1.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.tc.core.io.AbstractPairReader;
import de.tudarmstadt.ukp.dkpro.tc.io.TCReaderSingleLabel;
import de.tudarmstadt.ukp.dkpro.tc.type.TextClassificationOutcome;

/**
 * Reader for the SemEval 2014 Task 1 
 * "Evaluation of compositional distributional semantic models 
 * on full sentences through semantic relatedness and textual entailment"
 * 
 * @author zesch
 *
 */
public class SickReader
    extends AbstractPairReader implements TCReaderSingleLabel
{
    public enum Mode {
        relatedness,
        entailment
    }
    
    public static final String PARAM_INPUT_FILE = "inputFile";
    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
    protected File inputFile;

    public static final String PARAM_MODE = "mode";
    @ConfigurationParameter(name = PARAM_MODE, mandatory = true)
    protected Mode mode;
    
    private List<String> ids;
    private List<String> texts1;
    private List<String> texts2;
    private List<String> goldScores;
    private List<String> goldEntailments;

    private int fileOffset;

    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);

        fileOffset = 0;
        ids = new ArrayList<String>();
        texts1 = new ArrayList<String>();
        texts2 = new ArrayList<String>();
        goldScores = new ArrayList<String>();
        goldEntailments = new ArrayList<String>();

        try {
            for (String line : FileUtils.readLines(inputFile)) {
                String parts[] = line.split("\t");

                // format is: pair_ID \t sentence_A \t sentence_B \t relatedness_score \t entailment_judgment
                if (parts.length != 5) {
                    throw new ResourceInitializationException(new Throwable("Wrong file format: " + line));
                }
                String pairId = parts[0];
                String sentenceA = parts[1];
                String sentenceB = parts[2];
                String goldScore = parts[3];
                String goldEntailment = parts[4];

                // skip first line
                if (pairId.equals("pair_ID")) {
                    continue;
                }

                ids.add(pairId);
                texts1.add(sentenceA);
                texts2.add(sentenceB);
                if (mode.equals(Mode.relatedness)) {
                    goldScores.add(goldScore);             
                }
                else {
                    goldEntailments.add(goldEntailment);
                }
            }
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
    }

    public boolean hasNext()
        throws IOException, CollectionException
    {
        return fileOffset < texts1.size();
    }

    @Override
    public void getNext(JCas jcas)
        throws IOException, CollectionException
    {
        super.getNext(jcas);

        TextClassificationOutcome outcome = new TextClassificationOutcome(jcas);
        outcome.setOutcome(getTextClassificationOutcome(jcas));
        outcome.addToIndexes();

        // as we are creating more than one CAS out of a single file, we need to have different document titles and URIs for each CAS
        // otherwise, serialized CASes will be overwritten
        DocumentMetaData dmd = DocumentMetaData.get(jcas);
        dmd.setDocumentTitle(dmd.getDocumentTitle() + "-" + fileOffset);
        dmd.setDocumentUri(dmd.getDocumentUri() + "-" + fileOffset);
        fileOffset++;
    }

    public Progress[] getProgress()
    {
        return new Progress[] { new ProgressImpl(fileOffset, texts1.size(), Progress.ENTITIES) };
    }

    @Override
    protected String getCollectionId()
    {
        return inputFile.getParent();
    }

    @Override
    protected String getLanguage()
    {
        return "en";
    }

    @Override
    protected String getInitialViewText()
    {
        return texts1.get(fileOffset) + "\t" + texts2.get(fileOffset);
    }

    @Override
    protected String getInitialViewDocId()
    {
        return inputFile.getAbsolutePath() + "-" + fileOffset;
    }

    @Override
    protected String getInitialViewTitle()
    {
        return inputFile.getName() + "-" + fileOffset;
    }

    @Override
    protected String getBaseUri()
    {
        return inputFile.getParent();
    }

    @Override
    protected String getText(String part)
    {
        if (part.equals(PART_ONE)) {
            return texts1.get(fileOffset);
        }
        else if (part.equals(PART_TWO)) {
            return texts2.get(fileOffset);
        }
        return "";
    }

    public String getTextClassificationOutcome(JCas jcas)
        throws CollectionException
    {
        if (mode.equals(Mode.relatedness)) {
            return goldScores.get(fileOffset);
        }
        else {
            return goldEntailments.get(fileOffset);
        }
    }
}