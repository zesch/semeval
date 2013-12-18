package semeval2013.task7.io.util;

public class TaskQuestion
{
    private String questionType;
    private String id;
    private String module;
    private String questionStyle;
    private String text;
    
    public TaskQuestion() {
        this.questionType = null;
        this.id = null;
        this.module = null;
        this.questionStyle = null;
        this.text = null;
    }
    
    public TaskQuestion(String questionType, String id, String module, String questionStyle, String text)
    {
        super();
        this.questionType = questionType;
        this.id = id;
        this.module = module;
        this.questionStyle = questionStyle;
        this.text = text;
    }
    
    public String getQuestionType()
    {
        return questionType;
    }
    public void setQuestionType(String questionType)
    {
        this.questionType = questionType;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getModule()
    {
        return module;
    }
    public void setModule(String module)
    {
        this.module = module;
    }
    public String getQuestionStyle()
    {
        return questionStyle;
    }
    public void setQuestionStyle(String questionStyle)
    {
        this.questionStyle = questionStyle;
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
        sb.append("Text:\t");   sb.append(text);          sb.append("\n");
        sb.append("ID:\t");     sb.append(id);            sb.append("\n");
        sb.append("Style:\t");  sb.append(questionStyle); sb.append("\n");
        sb.append("Type:\t");   sb.append(questionType);  sb.append("\n");
        sb.append("Module:\t"); sb.append(module);        sb.append("\n");

        return sb.toString();
    }
    
    
}