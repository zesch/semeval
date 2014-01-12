package semeval2012.task7.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom4j.Dom4jXPath;

import semeval2012.task7.type.Alternative;
import semeval2012.task7.type.Statement;
import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.core.api.resources.ResourceUtils;

public class Task7Reader
    extends JCasCollectionReader_ImplBase
{   

    public static final String PARAM_INPUT_FILE = "inputFile";
    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
    protected String inputFile;
    
    private List<Task7Item> items;
    private int currentItem;
    
    @Override
    public void initialize(UimaContext context)
            throws ResourceInitializationException
    {
        super.initialize(context);
        
        items = new ArrayList<Task7Item>();
        currentItem = 0;
        
        Element root;
        try {
            URL url = ResourceUtils.resolveLocation(inputFile, this, context);
            SAXReader reader = new SAXReader();
            Document document = reader.read(new BufferedInputStream(url.openStream()));
            root = document.getRootElement();
        }
        catch (DocumentException e) {
            throw new ResourceInitializationException(e);
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
    
        try {  
            final XPath sentenceXP = new Dom4jXPath("//item");
            
            for (Object sentenceElement : sentenceXP.selectNodes(root)) {
                if (sentenceElement instanceof Element) {
                    Element sentenceNode = (Element) sentenceElement;
                    String id = getAttributeValue(sentenceNode, "id");
                    String asksFor = getAttributeValue(sentenceNode, "asks-for");
                    String mostPlausible = getAttributeValue(sentenceNode, "most-plausible-alternative");
                    
                    String statement = getText(sentenceNode, "descendant::p");
                    String a1 = getText(sentenceNode, "descendant::a1");
                    String a2 = getText(sentenceNode, "descendant::a2");
                    
                    Task7Item item = new Task7Item(statement, a1, a2, id, asksFor, mostPlausible);

                    items.add(item);
                }
            }
        }
        catch (JaxenException e) {
            throw new ResourceInitializationException(e);
        }
    }
    
    public boolean hasNext()
        throws IOException, CollectionException
    {
        return currentItem < items.size();
    }
    
    @Override
    public void getNext(JCas jcas)
        throws IOException, CollectionException
    {    
        Task7Item item = items.get(currentItem);

        jcas.setDocumentText(item.getStatement() + "\n" + item.getAlternative1() + "\n" + item.getAlternative2());
        jcas.setDocumentLanguage("en");
        
        Statement statement = new Statement(jcas, 0, item.getStatement().length());
        statement.setId(item.getId());
        statement.setAsksFor(item.getAsksFor());
        statement.setMostPlausibleAlternative(item.getMostPlausible());
        statement.addToIndexes();
        
        int offset = item.getStatement().length() + 1;
        
        Alternative alternative1 = new Alternative(jcas, offset, offset + item.getAlternative1().length());
        alternative1.setOffset("1");
        alternative1.addToIndexes();
        
        offset = offset + item.getAlternative1().length() + 1;
        
        Alternative alternative2 = new Alternative(jcas, offset, offset + item.getAlternative2().length());
        alternative2.setOffset("2");
        alternative2.addToIndexes();
        
        DocumentMetaData dmd = DocumentMetaData.create(jcas);
        dmd.setDocumentId(item.getId());
        
        currentItem++;
    }

    public Progress[] getProgress()
    {
        return new Progress[] { new ProgressImpl(currentItem, items.size(), "items") };
    }
    
    private String getAttributeValue(Element e, String name) {
        for (Object o : e.attributes()) {
            Attribute attribute = (Attribute) o;  
            if (name.equals(attribute.getName())) {
                return attribute.getValue();
            }
        }
        return null;
    }
    
    private String getText(Element root, String xPath)
            throws JaxenException
    {
        final XPath xp = new Dom4jXPath(xPath);
        
        for (Object element : xp.selectNodes(root)) {
            if (element instanceof Element) {
                Element node = (Element) element;
                return node.getText();
            }
        }
        
        return null;
    }
}