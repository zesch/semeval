package semeval2012.task7.io;


public class Task7Item
{

    private String statement;
    private String alternative1;
    private String alternative2;
    private String id;
    private String asksFor;
    private String mostPlausible;
    
    public Task7Item(
            String statement,
            String alternative1,
            String alternative2,
            String id,
            String asksFor,
            String mostPlausible)
    {
        this.statement = statement;
        this.alternative1 = alternative1;
        this.alternative2 = alternative2;
        this.id = id;
        this.asksFor = asksFor;
        this.mostPlausible = mostPlausible;
    }
    
    public String getStatement()
    {
        return statement;
    }

    public void setStatement(String statement)
    {
        this.statement = statement;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAsksFor()
    {
        return asksFor;
    }

    public void setAsksFor(String asksFor)
    {
        this.asksFor = asksFor;
    }

    public String getAlternative1()
    {
        return alternative1;
    }

    public void setAlternative1(String alternative1)
    {
        this.alternative1 = alternative1;
    }

    public String getAlternative2()
    {
        return alternative2;
    }

    public void setAlternative2(String alternative2)
    {
        this.alternative2 = alternative2;
    }

    public String getMostPlausible()
    {
        return mostPlausible;
    }

    public void setMostPlausible(String mostPlausible)
    {
        this.mostPlausible = mostPlausible;
    }
}