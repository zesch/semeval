package semeval2014.task4.io;

import java.util.HashMap;
import java.util.Map;

public class Task4Item
{

    private String sentence;
    private String id;
    private Map<String, String> terms;
    private Map<String, String> categories;
    
    public Task4Item(String sentence, String id)
    {
        this.id = id;
        this.sentence = sentence;
        this.terms = new HashMap<String, String>();
        this.categories = new HashMap<String, String>();
    }
    
    public void addTerm(String name, String value) {
        terms.put(name, value);
    }
    
    public void addCategory(String name, String value) {
        categories.put(name, value);
    }

    public String getSentence()
    {
        return sentence;
    }

    public void setSentence(String sentence)
    {
        this.sentence = sentence;
    }

    public Map<String, String> getTerms()
    {
        return terms;
    }
    
    public void setTerms(Map<String, String> terms)
    {
        this.terms = terms;
    }

    public Map<String, String> getCategories()
    {
        return categories;
    }

    public void setCategories(Map<String, String> categories)
    {
        this.categories = categories;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}