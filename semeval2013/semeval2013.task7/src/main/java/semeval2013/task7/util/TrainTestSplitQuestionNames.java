package semeval2013.task7.util;


public class TrainTestSplitQuestionNames
{
    private String[] train;
    private String[] test;

    public String[] getTrain()
    {
        return train;
    }
    public void setTrain(String ... train)
    {
        this.train = train;
    }
    public String[] getTest()
    {
        return test;
    }
    public void setTest(String ... test)
    {
        this.test = test;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Train:\n");
        for (String trainItem : train) {
            sb.append("  " + trainItem + "\n");
        }
        sb.append("Test:\n");
        for (String testItem : test) {
            sb.append("  " + testItem + "\n");
        }
        return sb.toString();
    }
}