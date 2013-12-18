package semeval2013.task7.io.util;

import java.util.List;

public class TaskGenericItem<R extends TaskReferenceAnswer, S extends TaskStudentAnswer>
{
    private TaskQuestion question;
    private List<R> referenceAnswers;
    private List<S> studentAnswers;
    
    public TaskGenericItem(TaskQuestion question, List<R> referenceAnswers,
            List<S> studentAnswers)
    {
        super();
        this.question = question;
        this.referenceAnswers = referenceAnswers;
        this.studentAnswers = studentAnswers;
    }
    
    public TaskQuestion getQuestion()
    {
        return question;
    }
    public void setQuestion(TaskQuestion question)
    {
        this.question = question;
    }
    public List<R> getReferenceAnswers()
    {
        return referenceAnswers;
    }
    public void setReferenceAnswers(List<R> referenceAnswers)
    {
        this.referenceAnswers = referenceAnswers;
    }
    public List<S> getStudentAnswers()
    {
        return studentAnswers;
    }
    public void setStudentAnswers(List<S> studentAnswers)
    {
        this.studentAnswers = studentAnswers;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("QUESTION:\n");
        sb.append(this.getQuestion());
        sb.append("\n");
        sb.append("REF-ANWSERS:\n");
        for (R refAnswer : this.getReferenceAnswers()) {
            sb.append("  ");
            sb.append(refAnswer);
            sb.append("\n");
        }
        sb.append("STUDENT-ANWSERS:\n");
        for (S studAnswer : this.getStudentAnswers()) {
            sb.append("  ");
            sb.append(studAnswer);
            sb.append("\n");
        }
        
        return sb.toString();
    }
}