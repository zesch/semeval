package semeval2013.task7.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import semeval2013.task7.Common.Dataset;

public class QuestionNameProviderForTests
{

    public enum TrainingModeForTest {
        sameQuestion,
        sameTopic,
        allQuestions
    }
    
    public static String[] getTrainData(String testQuestion, Dataset dataset, TrainingModeForTest trainingMode) {
        List<String> trainData = new ArrayList<String>();
        
        if (dataset.equals(Dataset.beetle)) {
            if (trainingMode.equals(TrainingModeForTest.sameQuestion)) {
                trainData.add(testQuestion);
            }
            else if (trainingMode.equals(TrainingModeForTest.sameTopic)) {
                trainData.addAll(getQuestionsSameTopic(testQuestion, QuestionNames.beetleQuestions, QuestionNames.beetleQuestionTypes));
            }
            else if (trainingMode.equals(TrainingModeForTest.allQuestions)) {
                trainData.addAll(Arrays.asList(QuestionNames.beetleQuestions));
            }
            else {
                throw new IllegalArgumentException("Unknown training mode for test: " + trainingMode.name());
            }
        }
        else if (dataset.equals(Dataset.sciEntsBank)) {
            if (trainingMode.equals(TrainingModeForTest.sameQuestion)) {
                trainData.add(testQuestion);
            }
            else if (trainingMode.equals(TrainingModeForTest.sameTopic)) {
                trainData.addAll(getQuestionsSameTopic(testQuestion, QuestionNames.sciEntsBankQuestions, QuestionNames.sciEntsBankQuestionTypes));
            }
            else if (trainingMode.equals(TrainingModeForTest.allQuestions)) {
                trainData.addAll(Arrays.asList(QuestionNames.sciEntsBankQuestions));
            }
            else {
                throw new IllegalArgumentException("Unknown training mode for test: " + trainingMode.name());
            }
        }
        else {
            throw new IllegalArgumentException("Unknown dataset: " + dataset.name());
        }
            
        return trainData.toArray(new String[0]);

    }
    
    private static List<String> getQuestionsSameTopic(String testQuestion, String[] allQuestions, String[] questionTypes) {

        List<String> questionsSameTopic = new ArrayList<String>(); 

        String selectedQuestionType = null;
        for (String questionType : questionTypes) {
            if (testQuestion.startsWith(questionType)) {
                selectedQuestionType = questionType;
            }
        }
        
        if (selectedQuestionType == null) {
            throw new RuntimeException("Could not match question " + testQuestion + " to any question type.");
        }
        
        for (String question : allQuestions) {
            if (question.startsWith(selectedQuestionType)) {
                questionsSameTopic.add(question);
            }
        }
        
        return questionsSameTopic;
    }    
}