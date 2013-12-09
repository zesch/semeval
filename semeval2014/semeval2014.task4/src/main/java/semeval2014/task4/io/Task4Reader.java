package semeval2014.task4.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import semeval2014.task4.type.AspectCategory;
import semeval2014.task4.type.AspectTerm;
import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.tudarmstadt.ukp.dkpro.core.api.resources.ResourceUtils;

public class Task4Reader
    extends JCasCollectionReader_ImplBase
{   

    public static final String PARAM_INPUT_FILE = "inputFile";
    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
    protected String inputFile;
    
    private List<Task4Item> items;
    private int currentItem;
    
    @Override
    public void initialize(UimaContext context)
            throws ResourceInitializationException
    {
        super.initialize(context);
        
        items = new ArrayList<Task4Item>();
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
            final XPath sentenceXP = new Dom4jXPath("//sentence");
            
            for (Object sentenceElement : sentenceXP.selectNodes(root)) {
                if (sentenceElement instanceof Element) {
                    Element sentenceNode = (Element) sentenceElement;
                    String id = getAttributeValue(sentenceNode, "id");
                    String sentence = getText(sentenceNode, "text");
                                        
                    Task4Item item = new Task4Item(sentence, id);
                    
                    final XPath termXP = new Dom4jXPath("descendant::aspectTerm");
                    for (Object term : termXP.selectNodes(sentenceElement)) {
                        if (term instanceof Element) {
                            Element termNode = (Element) term;
                            String token = getAttributeValue(termNode, "term");
                            String polarity = getAttributeValue(termNode, "polarity");

                            item.addTerm(token, polarity);
                        }             
                    }
                    
                    final XPath categoryXP = new Dom4jXPath("descendant::aspectCategory");
                    for (Object categoryElement : categoryXP.selectNodes(sentenceElement)) {
                        if (categoryElement instanceof Element) {
                            Element categoryNode = (Element) categoryElement;
                            String category = getAttributeValue(categoryNode, "category");
                            String polarity = getAttributeValue(categoryNode, "polarity");

                            item.addCategory(category, polarity);
                        }             
                    }

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
        Task4Item item = items.get(currentItem);

        jcas.setDocumentText(item.getSentence());
        jcas.setDocumentLanguage("en");
        
        Map<String, String> terms = item.getTerms();
        for (String key : terms.keySet()) {
            AspectTerm term = new AspectTerm(jcas);
            term.setTerm(key);
            term.setPolarity(terms.get(key));
            term.addToIndexes();
        }
        
        Map<String, String> categories = item.getCategories();
        for (String key : categories.keySet()) {
            AspectCategory category = new AspectCategory(jcas);
            category.setCategory(key);
            category.setPolarity(categories.get(key));
            category.addToIndexes();
        }
        
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