package semeval2013.task7.io.util;

public class TaskStudentAnswer
    extends TaskAnswer
{
    private int count;
    private String answerMatch;
    private String label;

    public TaskStudentAnswer()
    {
        super();
        initialize(0, null, null);
    }
    
    public TaskStudentAnswer(String id, String text)
    {
        super(id, text);
        initialize(0, null, null);
    }
    
    public TaskStudentAnswer(String id, String text, int count, String answerMatch, String label)
    {
        super(id, text);
        initialize(count, answerMatch, label);
    }

    private void initialize(int count, String answerMatch, String label) {
        this.count = count;
        this.answerMatch = answerMatch;
        this.label = label;
    }
    
    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public String getAnswerMatch()
    {
        return answerMatch;
    }

    public void setAnswerMatch(String answerMatch)
    {
        this.answerMatch = answerMatch;
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
        sb.append(this.getLabel());
        sb.append("\t");
        sb.append(super.toString());
        sb.append("\t");
        sb.append(this.getAnswerMatch());
        sb.append("\t");
        sb.append(this.getCount());
        
        return sb.toString();
    }
}