package semeval2013.task7.io.util;

public class TaskFacetEntailment
{

    private String facetId;
    private String label;
    
    public TaskFacetEntailment() {
        this(null, null);
    }
    
    public TaskFacetEntailment(String facetId, String label)
    {
        super();
        this.facetId = facetId;
        this.label = label;
    }

    public String getFacetId()
    {
        return facetId;
    }

    public void setFacetId(String facetId)
    {
        this.facetId = facetId;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getFacetId());
        sb.append("\t");
        sb.append(this.getLabel());
        
        return sb.toString();
    }
}