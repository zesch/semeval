package semeval2014.task10.io;

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

public class STSReader
    extends AbstractPairReader implements TCReaderSingleLabel
{

    public static final String PARAM_INPUT_FILES = "InputFiles";
    @ConfigurationParameter(name = PARAM_INPUT_FILES, mandatory = true)
    protected File[] inputFiles;

    public static final String PARAM_GOLD_FILES = "GoldFiles";
    @ConfigurationParameter(name = PARAM_GOLD_FILES, mandatory = true)
    protected File[] goldFiles;

    private List<String> texts1;
    private List<String> texts2;
    private List<String> golds;

    private int fileOffset;

    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);

        fileOffset = 0;
        texts1 = new ArrayList<String>();
        texts2 = new ArrayList<String>();
        golds = new ArrayList<String>();

        try {
            for (File inputFile : inputFiles) {
                for (String line : FileUtils.readLines(inputFile)) {
                    String parts[] = line.split("\t");

                    if (parts.length != 2) {
                        throw new ResourceInitializationException(new Throwable("Wrong file format: " + line));
                    }

                    texts1.add(parts[0]);
                    texts2.add(parts[1]);
                }  
            }
            
            for (File goldFile : goldFiles) {
                for (String line : FileUtils.readLines(goldFile)) {
                    golds.add(line);
                } 
            }   

            if (texts1.size() != golds.size()) {
                throw new ResourceInitializationException(new Throwable("Size of text list does not match size of gold list."));
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
        return inputFiles[0].getParent();
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
        return inputFiles[0].getName() + "-" + fileOffset;
    }

    @Override
    protected String getInitialViewTitle()
    {
        return inputFiles[0].getName() + "-" + fileOffset;
    }

    @Override
    protected String getBaseUri()
    {
        return inputFiles[0].getParent();
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
    {
        return golds.get(fileOffset);
    }
}