package semeval2013.task7.io.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom4j.Dom4jXPath;

public class TransformationUtil
{
    public static TaskGenericItem<TaskReferenceAnswer, TaskStudentAnswer> xml2Task(InputStream is)
        throws DocumentException, JaxenException
    {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new BufferedInputStream(is));
        Element root = document.getRootElement();
    
        TaskQuestion question = new TaskQuestion();
        List<TaskReferenceAnswer> referenceAnswers = null;
        List<TaskStudentAnswer> studentAnswers = null;
    
        final XPath questionXPath = new Dom4jXPath("//question");
        for (Object element : questionXPath.selectNodes(root)) {
            if (element instanceof Element) {
                Element node = (Element) element;

                
                for (Object o : node.attributes()) {
                    Attribute attribute = (Attribute) o;  
                    String name = attribute.getName();
                    if (name.equals("qtype")) {
                        question.setQuestionType(attribute.getValue());
                    }
                    else if (name.equals("id")) {
                        question.setId(attribute.getValue());
                    } 
                    else if (name.equals("module")) {
                        question.setModule(attribute.getValue());
                    } 
                    else if (name.equals("stype")) {
                        question.setQuestionStyle(attribute.getValue());
                    } 
                    else if (name.equals("testSet")) {
                        // ignore this additional attribute which only appears in the test set
                    }
                    else {
                        System.err.println("Unknown attribute: " + name);
                    } 
                }
                
                final XPath qTextXP = new Dom4jXPath("./questionText");
                for (Object qTextElement : qTextXP.selectNodes(root)) {
                    if (qTextElement instanceof Element) {
                        Element qText = (Element) qTextElement;
                        question.setText(qText.getText());
                    }
                }
                
                referenceAnswers = getReferenceAnswers(root);
                studentAnswers = getStudentAnswers(root);
            }
        }
        
        TaskGenericItem<TaskReferenceAnswer, TaskStudentAnswer> item = new TaskGenericItem<TaskReferenceAnswer, TaskStudentAnswer>(question, referenceAnswers, studentAnswers);

        return item;
    }

    private static List<TaskReferenceAnswer> getReferenceAnswers(Element rootNode)
            throws JaxenException
    {
        List<TaskReferenceAnswer> answers = new ArrayList<TaskReferenceAnswer>();
        
        final XPath refAnswerXPath = new Dom4jXPath("//referenceAnswer");
        for (Object refAnswerElement : refAnswerXPath.selectNodes(rootNode)) {
            if (refAnswerElement instanceof Element) {
                Element refAnswerNode = (Element) refAnswerElement;

                TaskReferenceAnswer answer = new TaskReferenceAnswer();
                
                answer.setText(refAnswerNode.getText());
                
                for (Object o : refAnswerNode.attributes()) {
                    Attribute attribute = (Attribute) o;  
                    String name = attribute.getName();
                    if (name.equals("category")) {
                        answer.setCategory(attribute.getValue());
                    }
                    else if (name.equals("id")) {
                        answer.setId(attribute.getValue());
                    } 
                    else if (name.equals("fileID")) {
                        answer.setFileId(attribute.getValue());
                    } 
                    else {
                        System.err.println("Unknown attribute: " + name);
                    } 
                }
                
                answers.add(answer);
            }
        }
        
        return answers;
    }

    private static List<TaskStudentAnswer> getStudentAnswers(Element rootNode)
            throws JaxenException
    {
        List<TaskStudentAnswer> answers = new ArrayList<TaskStudentAnswer>();
        
        final XPath answerXPath = new Dom4jXPath("//studentAnswer");
        for (Object answerElement : answerXPath.selectNodes(rootNode)) {
            if (answerElement instanceof Element) {
                Element answerNode = (Element) answerElement;

                TaskStudentAnswer answer = new TaskStudentAnswer();
                
                answer.setText(answerNode.getText());
                
                for (Object o : answerNode.attributes()) {
                    Attribute attribute = (Attribute) o;  
                    String name = attribute.getName();
                    if (name.equals("count")) {
                        answer.setCount(Integer.parseInt(attribute.getValue()));
                    }
                    else if (name.equals("id")) {
                        answer.setId(attribute.getValue());
                    } 
                    else if (name.equals("answerMatch")) {
                        answer.setAnswerMatch(attribute.getValue());
                    } 
                    else if (name.equals("accuracy")) {
                        answer.setLabel(attribute.getValue());
                    } 
                    else {
                        System.err.println("Unknown attribute: " + name);
                    } 
                }

                answers.add(answer);
            }
        }
        
        return answers;
    }
}
