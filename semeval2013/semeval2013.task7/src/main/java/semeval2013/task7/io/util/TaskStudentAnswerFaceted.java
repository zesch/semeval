package semeval2013.task7.io.util;

import java.util.ArrayList;
import java.util.List;

public class TaskStudentAnswerFaceted
    extends TaskStudentAnswer
{

    private List<TaskFacetEntailment> facetEntailments;
    
    public TaskStudentAnswerFaceted() {
        
    }

    public TaskStudentAnswerFaceted(List<TaskFacetEntailment> facetEntailments)
    {
        super();
        this.facetEntailments = facetEntailments;
    }

    public List<TaskFacetEntailment> getFacetEntailments()
    {
        return facetEntailments;
    }

    public void setFacetEntailments(List<TaskFacetEntailment> facetEntailments)
    {
        this.facetEntailments = facetEntailments;
    }
    
    public void addFacet(TaskFacetEntailment facetEntailment) {
        if (this.facetEntailments == null) {
            this.facetEntailments = new ArrayList<TaskFacetEntailment>();
        }
        this.facetEntailments.add(facetEntailment);
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n");
        for (TaskFacetEntailment facetEntailment : this.getFacetEntailments()) {
            sb.append("  ");
            sb.append(facetEntailment);
            sb.append("\n");
        }
        
        return sb.toString();
    }
}
