package semeval2013.task7.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import semeval2013.task7.Common.Dataset;

public class QuestionNameProvider
{

    public enum TrainingMode {
        sameTopic1Q,
        sameTopicAllQ,
        differentTopic
    }
    
    public static String[] getTrainData(Dataset dataset, TrainingMode trainingMode, int id) {
        return getQuestionMap(dataset, trainingMode).get(id).getTrain();
    }
    
    public static String[] getTestData(Dataset dataset, TrainingMode trainingMode, int id) {
        return getQuestionMap(dataset, trainingMode).get(id).getTest();
    }

    public static Integer[] getSetIds(Dataset dataset, TrainingMode trainingMode) {
        return getQuestionMap(dataset, trainingMode).keySet().toArray(new Integer[0]);
    }

    private static Map<Integer, TrainTestSplitQuestionNames> getQuestionMap(Dataset dataset, TrainingMode trainingMode) {
        Map<Integer,TrainTestSplitQuestionNames> questionMap = new HashMap<Integer,TrainTestSplitQuestionNames>();
        
        if (dataset.equals(Dataset.beetle)) {
            if (trainingMode.equals(TrainingMode.sameTopic1Q)) {
                questionMap = getQuestionMap1Q(QuestionNames.beetleQuestions, QuestionNames.beetleQuestionTypes);
            }
            else if (trainingMode.equals(TrainingMode.sameTopicAllQ)) {
                questionMap = getQuestionMapAllQ(QuestionNames.beetleQuestions, QuestionNames.beetleQuestionTypes);
            }
            else if (trainingMode.equals(TrainingMode.differentTopic)) {
                questionMap = getQuestionMapTopic(QuestionNames.beetleQuestions, QuestionNames.beetleTopic);
            }
            else {
                throw new IllegalArgumentException("Unknown training mode: " + trainingMode.name());
            }
        }
        else if (dataset.equals(Dataset.sciEntsBank)) {
            if (trainingMode.equals(TrainingMode.sameTopic1Q)) {
                questionMap = getQuestionMap1Q(QuestionNames.sciEntsBankQuestions, QuestionNames.sciEntsBankQuestionTypes);
            }
            else if (trainingMode.equals(TrainingMode.sameTopicAllQ)) {
                questionMap = getQuestionMapAllQ(QuestionNames.sciEntsBankQuestions, QuestionNames.sciEntsBankQuestionTypes);
            }
            else if (trainingMode.equals(TrainingMode.differentTopic)) {
                questionMap = getQuestionMapTopic(QuestionNames.sciEntsBankQuestions, QuestionNames.sciEntsBankTopics);
            }
            else {
                throw new IllegalArgumentException("Unknown training mode: " + trainingMode.name());
            }
        }
        else {
            throw new IllegalArgumentException("Unknown dataset: " + dataset.name());
        }
            
        return questionMap;

    }
    
    private static Map<Integer,TrainTestSplitQuestionNames> getQuestionMap1Q(String[] questions, String[] prefixes) {
        Map<Integer,TrainTestSplitQuestionNames> questionMap = new HashMap<Integer,TrainTestSplitQuestionNames>();

        int id = 0;
        for (String prefix : prefixes) {
            List<String> topicQuestions = new ArrayList<String>();
            for (String question : questions) {
                if (question.startsWith(prefix)) {
                    topicQuestions.add(question);
                }
            }
            for (TrainTestSplitQuestionNames split : getSplits1Q(topicQuestions)) {
                questionMap.put(id, split);
                id++;
            }
        }
        
        return questionMap;
    }
    
    private static List<TrainTestSplitQuestionNames> getSplits1Q(List<String> questions) {
        List<TrainTestSplitQuestionNames> splits = new ArrayList<TrainTestSplitQuestionNames>();
        
        for (String question : questions) {
            Set<String> fullSet = new HashSet<String>(questions);
            fullSet.remove(question);
            
            TrainTestSplitQuestionNames split = new TrainTestSplitQuestionNames();
            split.setTrain(question);
            split.setTest(fullSet.toArray(new String[0]));
            splits.add(split);
        }
        
        return splits;
    }    

    private static Map<Integer,TrainTestSplitQuestionNames> getQuestionMapAllQ(String[] questions, String[] prefixes) {
        Map<Integer,TrainTestSplitQuestionNames> questionMap = new HashMap<Integer,TrainTestSplitQuestionNames>();

        int id = 0;
        for (String prefix : prefixes) {
            List<String> topicQuestions = new ArrayList<String>();
            for (String question : questions) {
                if (question.startsWith(prefix)) {
                    topicQuestions.add(question);
                }
            }
            for (TrainTestSplitQuestionNames split : getSplitsAllQ(topicQuestions)) {
                questionMap.put(id, split);
                id++;
            }
        }
        
        return questionMap;
    }

    private static List<TrainTestSplitQuestionNames> getSplitsAllQ(List<String> questions) {
        List<TrainTestSplitQuestionNames> splits = new ArrayList<TrainTestSplitQuestionNames>();
        
        for (String question : questions) {
            Set<String> fullSet = new HashSet<String>(questions);
            fullSet.remove(question);
            
            TrainTestSplitQuestionNames split = new TrainTestSplitQuestionNames();
            split.setTrain(fullSet.toArray(new String[0]));
            split.setTest(question);
            splits.add(split);
        }
        
        return splits;
    }    

    private static Map<Integer,TrainTestSplitQuestionNames> getQuestionMapTopic(String[] questions, String[] prefixes) {
        Map<Integer,TrainTestSplitQuestionNames> questionMap = new HashMap<Integer,TrainTestSplitQuestionNames>();

        int id = 0;
        List<List<String>> questionsPerTopic = new ArrayList<List<String>>(); 
        for (String prefix : prefixes) {
            List<String> topicQuestions = new ArrayList<String>();
            for (String question : questions) {
                if (question.startsWith(prefix)) {
                    topicQuestions.add(question);
                }
            }
            questionsPerTopic.add(topicQuestions);
        }
        
        for (List<String> topicQuestions : questionsPerTopic) {
            Set<String> fullSet = new HashSet<String>(Arrays.asList(questions));
            fullSet.removeAll(topicQuestions);

            TrainTestSplitQuestionNames split = new TrainTestSplitQuestionNames();
            split.setTrain(topicQuestions.toArray(new String[0]));
            split.setTest(fullSet.toArray(new String[0]));
            questionMap.put(id, split);
            id++;
        }
        
        return questionMap;
    }    
}