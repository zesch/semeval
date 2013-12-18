package semeval2013.task7.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import semeval2013.task7.Common.TaskFormat;
import semeval2013.task7.type.GoldAssessmentResult;
import semeval2013.task7.type.StudentAnswer;
import semeval2013.task7.util.OSUtil;
import semeval2013.task7.util.OSUtil.OSTypes;
import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;

public class SemEval2013Task7Evaluator
    extends JCasAnnotator_ImplBase
{

    public static final String PARAM_RESULTS_FILE = "ResultsFile";
    @ConfigurationParameter(name=PARAM_RESULTS_FILE, mandatory=true)
    private File resultsFile;
    
    public static final String PARAM_TASK_FORMAT = "TaskFormat";
    @ConfigurationParameter(name=PARAM_TASK_FORMAT, mandatory=true)
    private TaskFormat taskFormat;

    Map<String,String> goldMap;
    Map<String,String> resultMap;

    int correct = 0;
    int wrong = 0;

    
    
    @Override
    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);
        
        goldMap = new HashMap<String,String>();
        resultMap = new HashMap<String,String>();
    }

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        DocumentMetaData dmd = DocumentMetaData.get(jcas);
        String id = dmd.getDocumentId();
        
        for (StudentAnswer studentAnswer : JCasUtil.select(jcas,  StudentAnswer.class)) {
            List<GoldAssessmentResult> results = JCasUtil.selectCovered(jcas, GoldAssessmentResult.class, studentAnswer);
            
            if (results.size() != 1) {
                throw new AnalysisEngineProcessException(new Throwable("More than one gold annotation for a student answer found."));
            }
            
            String gold = studentAnswer.getLabel();
            String computed = results.get(0).getResult();

            goldMap.put(id, gold);
            resultMap.put(id, computed);
            
//            System.out.println(gold + " - " + computed);
        
            if (gold.equals(computed)) {
                correct++;
            }
            else {
                wrong++;
            }        
        }
    }

    @Override
    public void collectionProcessComplete()
        throws AnalysisEngineProcessException
    {
        double accuracy = (double) correct / (correct + wrong);
        System.out.println("Accuracy: " + accuracy);
        try {
            FileUtils.writeStringToFile(resultsFile, "accuracy:" + accuracy);
        }
        catch (IOException e) {
            throw new AnalysisEngineProcessException(e);
        }
        
        try {
            File goldFile = File.createTempFile("semEval2013Task7", ".txt");
            writeMap(goldFile, goldMap);
            File resultFile = File.createTempFile("semEval2013Task7", ".txt");
            writeMap(resultFile, resultMap);

            String mode = null;
            if (taskFormat.equals(TaskFormat.twoWay)) {
                mode = "2way";
            }
            else if (taskFormat.equals(TaskFormat.threeWay)) {
                mode = "3way";
            } 
            else if (taskFormat.equals(TaskFormat.fiveWay)) {
                mode = "5way";
            } 

            String command = "Rscript -e 'source(\"src/main/resources/eval/evaluation.R\");run.evaluation(\"" + resultFile.getAbsolutePath() + "\", \"" + goldFile.getAbsolutePath() + "\", \"" + mode + "\")'";

            runProcess(command);
        }
        catch (IOException e) {
            throw new AnalysisEngineProcessException(e);
        }
    }
    
    private void writeMap(File file, Map<String,String> map) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        // header
        sb.append("id\tvalues\n");

        // content
        for (String key : map.keySet()) {
            sb.append(key + "\t" + map.get(key) + "\n");
        }
        
        FileUtils.writeStringToFile(file, sb.toString());
    }

    private void runProcess(String command) throws IOException {
        ProcessBuilder mProBuilder = null;
        Process mProcess;
        BufferedReader mResultReader;
        
        System.out.println(command);
        
        if (OSUtil.getOsType().equals(OSTypes.Windows)) {
            mProBuilder = new ProcessBuilder("cmd.exe","/C", command );
        }
        else if (OSUtil.getOsType().equals(OSTypes.Linux)) {
            mProBuilder = new ProcessBuilder("/bin/sh","-c", command );
        }
        else {
            mProBuilder = new ProcessBuilder("/bin/sh","-c", command );
        }

        mProcess = mProBuilder.start();
        mResultReader = new BufferedReader( new InputStreamReader( mProcess.getInputStream()) );

        while(!mResultReader.ready()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
            
        while (mResultReader.ready()) {
            String line = mResultReader.readLine();
            if (line==null) {
                throw new IOException("Unexpected end of OutputStream.");
            }

            System.out.println(line);
        }
    }
}
