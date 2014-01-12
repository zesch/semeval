package semeval2012.task7;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import semeval2012.task7.io.Task7Reader;
import semeval2012.task7.type.Statement;

public class RunSimpleCopaBaseline
{
    public static void main(String[] args)
        throws Exception
    {
        CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
                Task7Reader.class,
                Task7Reader.PARAM_INPUT_FILE, "classpath:/copa/copa-dev.xml"
        );
        
        int correct = 0;
        int nrOfItems = 0;
                    
        // iterate over all items
        for (JCas jcas : new JCasIterable(reader)) {
            
//            System.out.println(jcas.getDocumentText());
            
            // get the statement
            Statement statement = JCasUtil.selectSingle(jcas, Statement.class);
            
            // always-first baseline
            if (statement.getMostPlausibleAlternative().equals("1")) {
                correct++;
            }
            
            nrOfItems++;
        }
        
        System.out.println("Accuracy: " + (double) correct / nrOfItems);
    }
}
