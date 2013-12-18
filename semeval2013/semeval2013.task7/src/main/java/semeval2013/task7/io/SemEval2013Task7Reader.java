package semeval2013.task7.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.dom4j.DocumentException;
import org.jaxen.JaxenException;

import semeval2013.task7.io.util.TaskGenericItem;
import semeval2013.task7.io.util.TaskQuestion;
import semeval2013.task7.io.util.TaskReferenceAnswer;
import semeval2013.task7.io.util.TaskStudentAnswer;
import semeval2013.task7.io.util.TransformationUtil;
import semeval2013.task7.type.Question;
import semeval2013.task7.type.ReferenceAnswer;
import semeval2013.task7.type.StudentAnswer;
import de.tudarmstadt.ukp.dkpro.core.api.io.JCasResourceCollectionReader_ImplBase;

public class SemEval2013Task7Reader
    extends JCasResourceCollectionReader_ImplBase
{
    
    @Override
    public void getNext(JCas jcas)
        throws IOException, CollectionException
    {
        Resource res = nextFile();
        initCas(jcas, res);
    
        TaskGenericItem<TaskReferenceAnswer, TaskStudentAnswer> taskItem;
        try {
            taskItem = TransformationUtil.xml2Task(res.getInputStream());
        }
        catch (JaxenException e) {
            throw new CollectionException(e);
        }
        catch (DocumentException e) {
            throw new CollectionException(e);
        }

        // add task item to CAS and add appropriate annotations
        int offset = 0;
        StringBuilder sb = new StringBuilder();
        
        TaskQuestion taskQuestion = taskItem.getQuestion();
        sb.append(taskQuestion.getText());
        offset += taskQuestion.getText().length();
        
        Question q = new Question(jcas, 0, offset);
        q.setId(taskQuestion.getId());
        q.setModule(taskQuestion.getModule());
        q.setQtype(taskQuestion.getQuestionType());
        q.setStyle(taskQuestion.getQuestionStyle());
        
        sb.append("\n");
        offset++;
        
        List<ReferenceAnswer> referenceAnswers = new ArrayList<ReferenceAnswer>();
        Map<String,ReferenceAnswer> id2refAnswerMap = new HashMap<String,ReferenceAnswer>();
        for (TaskReferenceAnswer taskRefAnswer : taskItem.getReferenceAnswers()) {
            int startOffset = offset;
            sb.append(taskRefAnswer.getText());
            offset += taskRefAnswer.getText().length();
            
            ReferenceAnswer referenceAnswer = new ReferenceAnswer(jcas, startOffset, offset);
            referenceAnswer.setCategory(taskRefAnswer.getCategory());
            referenceAnswer.setFileId(taskRefAnswer.getFileId());
            referenceAnswer.setId(taskRefAnswer.getId());

            referenceAnswers.add(referenceAnswer);
            id2refAnswerMap.put(referenceAnswer.getId(), referenceAnswer);
            
            sb.append("\n");
            offset++;
        }

        List<StudentAnswer> studentAnswers = new ArrayList<StudentAnswer>();
        for (TaskStudentAnswer taskStudentAnswer : taskItem.getStudentAnswers()) {
            int startOffset = offset;
            sb.append(taskStudentAnswer.getText());
            offset += taskStudentAnswer.getText().length();
            
            StudentAnswer studentAnswer = new StudentAnswer(jcas, startOffset, offset);
            if (taskStudentAnswer.getAnswerMatch() != null && id2refAnswerMap.containsKey(taskStudentAnswer.getAnswerMatch())) {
                studentAnswer.setAnswerMatch(id2refAnswerMap.get(taskStudentAnswer.getAnswerMatch()));
            }
            studentAnswer.setCount(taskStudentAnswer.getCount());
            studentAnswer.setId(taskStudentAnswer.getId());
            studentAnswer.setLabel(taskStudentAnswer.getLabel());

            studentAnswers.add(studentAnswer);
            
            sb.append("\n");
            offset++;
        }
        
        jcas.setDocumentText(sb.toString());
        
        // finally add all annotations to indexes
        q.addToIndexes();
        for (ReferenceAnswer refAnswer : referenceAnswers) {
            refAnswer.addToIndexes();
        }
        for (StudentAnswer studAnswer : studentAnswers) {
            studAnswer.addToIndexes();
        }
    }
}