package semeval2013.task7.io.util;

public class TaskAnswer
{
    private String id;
    private String text;

    public TaskAnswer()
    {
        this.id = null;
        this.text = null;
    }
    
    public TaskAnswer(String id, String text)
    {
        super();
        this.id = id;
        this.text = text;
    }
    
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId());
        sb.append("\t");
        sb.append(this.getText());
        
        return sb.toString();
    }
}