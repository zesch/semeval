package semeval2013.task7.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;

import semeval2013.task7.task.SemEval2013TaskBase;
import de.tudarmstadt.ukp.dkpro.lab.reporting.BatchReportBase;
import de.tudarmstadt.ukp.dkpro.lab.reporting.FlexTable;
import de.tudarmstadt.ukp.dkpro.lab.storage.StorageService;
import de.tudarmstadt.ukp.dkpro.lab.storage.impl.PropertiesAdapter;
import de.tudarmstadt.ukp.dkpro.lab.task.Task;
import de.tudarmstadt.ukp.dkpro.lab.task.TaskContextMetadata;

public class SimpleOverviewReport
    extends BatchReportBase
{
    private static final String EVALUATION_FILE_XLS = "eval.xls";
    private static final String EVALUATION_FILE_CSV = "eval.csv";

    public void execute()
        throws Exception
    {
        StorageService store = getContext().getStorageService();

        FlexTable<String> table = FlexTable.forClass(String.class);

        Map<String, List<Double>> key2resultValues = new HashMap<String, List<Double>>();

        for (TaskContextMetadata subcontext : getSubtasks()) {
            Map<String, String> discriminatorsMap = store.retrieveBinary(subcontext.getId(),
                    Task.DISCRIMINATORS_KEY, new PropertiesAdapter()).getMap();
            Map<String, String> resultMap = store.retrieveBinary(subcontext.getId(),
                    SemEval2013TaskBase.RESULTS_FOLDER + "/" + SemEval2013TaskBase.RESULTS_FILE, new PropertiesAdapter()).getMap();

            String key = getKey(discriminatorsMap);

            double accuracy = Double.valueOf(resultMap.get("accuracy"));

            List<Double> results;
            if (key2resultValues.get(key) == null) {
                results = new ArrayList<Double>();
            }
            else {
                results = key2resultValues.get(key);

            }
            results.add(accuracy);
            key2resultValues.put(key, results);

            Map<String, String> values = new HashMap<String, String>();
            values.putAll(discriminatorsMap);
            values.putAll(resultMap);

            table.addRow(subcontext.getLabel(), values);
        }

        table.setCompact(false);
        getContext().storeBinary(EVALUATION_FILE_XLS, table.getExcelWriter());
        getContext().storeBinary(EVALUATION_FILE_CSV, table.getCsvWriter());
    }

    private String getKey(Map<String, String> discriminatorsMap)
    {
        Set<String> sortedDiscriminators = new TreeSet<String>(discriminatorsMap.keySet());

        List<String> values = new ArrayList<String>();
        for (String discriminator : sortedDiscriminators) {
            values.add(discriminatorsMap.get(discriminator));
        }
        return StringUtils.join(values, "_");
    }
}