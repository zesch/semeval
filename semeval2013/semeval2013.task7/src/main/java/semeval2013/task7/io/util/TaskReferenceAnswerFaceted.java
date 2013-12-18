package semeval2013.task7.io.util;

import java.util.ArrayList;
import java.util.List;

public class TaskReferenceAnswerFaceted
    extends TaskReferenceAnswer
{

    private List<TaskFacet> facets;

    public TaskReferenceAnswerFaceted() {
        
    }
    
    public TaskReferenceAnswerFaceted(List<TaskFacet> facets)
    {
        super();
        this.facets = facets;
    }

    public List<TaskFacet> getFacets()
    {
        return facets;
    }

    public void setFacets(List<TaskFacet> facets)
    {
        this.facets = facets;
    }
    
    public void addFacet(TaskFacet facet) {
        if (this.facets == null) {
            this.facets = new ArrayList<TaskFacet>();
        }
        this.facets.add(facet);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n");
        for (TaskFacet facet : this.getFacets()) {
            sb.append("  ");
            sb.append(facet);
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
