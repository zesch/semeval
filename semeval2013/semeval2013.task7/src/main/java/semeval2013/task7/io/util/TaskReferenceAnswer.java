package semeval2013.task7.io.util;

public class TaskReferenceAnswer
    extends TaskAnswer
{
    private String category;
    private String fileId;

    public TaskReferenceAnswer()
    {
        super();
        initialize(null,  null);
    }
    
    public TaskReferenceAnswer(String id, String text)
    {
        super(id, text);
        initialize(null,  null);
    }

    public TaskReferenceAnswer(String id, String text, String category, String fileId)
    {
        super(id, text);
        initialize(category, fileId);
    }
    
    private void initialize(String category, String fileId) {
        this.category = category;
        this.fileId = fileId;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getFileId()
    {
        return fileId;
    }

    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getCategory());
        sb.append("\t");
        sb.append(super.toString());
        sb.append("\t");
        sb.append(this.getFileId());
        
        return sb.toString();
    }    
}