package semeval2013.task7.task;

import java.io.IOException;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.resource.ResourceInitializationException;

import semeval2013.task7.io.SemEval2013Task7Reader;
import de.tudarmstadt.ukp.dkpro.lab.engine.TaskContext;
import de.tudarmstadt.ukp.dkpro.lab.task.Discriminator;
import de.tudarmstadt.ukp.dkpro.lab.uima.task.impl.UimaTaskBase;

public abstract class SemEval2013TaskBase
    extends UimaTaskBase
{
    public static final String RESULTS_FOLDER = "results";
    public static final String RESULTS_FILE = "results.prop";
    
    @Discriminator String dataset;
    
    public CollectionReaderDescription getCollectionReaderDescription(TaskContext aContext)
        throws ResourceInitializationException, IOException
    {
        String path = "src/main/resources/train/" + dataset;

        return CollectionReaderFactory.createReaderDescription(
                SemEval2013Task7Reader.class, 
                SemEval2013Task7Reader.PARAM_SOURCE_LOCATION, path, 
                SemEval2013Task7Reader.PARAM_PATTERNS, new String[] {
                    SemEval2013Task7Reader.INCLUDE_PREFIX + "*.xml"
                }
        );
    }
}