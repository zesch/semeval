package semeval2013.task7.io.util;

public class TaskFacet
{
    private String id;
    private String term1Num;
    private String term1Text;
    private String term2Num;
    private String term2Text;
    private boolean isAssumed;
   
    public TaskFacet() {
        this(null, null, null, null, null, false);
    }
    public TaskFacet(String id, String term1Num, String term1Text, String term2Num,
            String term2Text, boolean isAssumed)
    {
        super();
        this.id = id;
        this.term1Num = term1Num;
        this.term1Text = term1Text;
        this.term2Num = term2Num;
        this.term2Text = term2Text;
        this.isAssumed = isAssumed;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTerm1Num()
    {
        return term1Num;
    }

    public void setTerm1Num(String term1Num)
    {
        this.term1Num = term1Num;
    }

    public String getTerm1Text()
    {
        return term1Text;
    }

    public void setTerm1Text(String term1Text)
    {
        this.term1Text = term1Text;
    }

    public String getTerm2Num()
    {
        return term2Num;
    }

    public void setTerm2Num(String term2Num)
    {
        this.term2Num = term2Num;
    }

    public String getTerm2Text()
    {
        return term2Text;
    }

    public void setTerm2Text(String term2Text)
    {
        this.term2Text = term2Text;
    }

    public boolean isAssumed()
    {
        return isAssumed;
    }

    public void setAssumed(boolean isAssumed)
    {
        this.isAssumed = isAssumed;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId());
        sb.append("\t");
        sb.append(this.getTerm1Num());
        sb.append("\t");
        sb.append(this.getTerm1Text());
        sb.append("\t");
        sb.append(this.getTerm2Num());
        sb.append("\t");
        sb.append(this.getTerm2Text());
        sb.append("\t");
        sb.append(this.isAssumed());
        
        return sb.toString();
    }
}