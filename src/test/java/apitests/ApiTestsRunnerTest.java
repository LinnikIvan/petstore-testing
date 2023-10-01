package apitests;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@KarateOptions(features = "src/test/resources",
        tags = {"@ApiTests", "~@ignore"})
public class ApiTestsRunnerTest {

    private static final String KARATE_OUTPUT_PATH = "/";

    @Test
    public void testParallel() {
        final Results stats = Runner.parallel(getClass(), 1, KARATE_OUTPUT_PATH);
        generateReport();
        assertThat("scenarios failed", stats.getFailCount(), is(0));
    }

    private void generateReport() {
        List<String> jsonPaths = FileUtils.listFiles(new File(KARATE_OUTPUT_PATH), new String[]{"json"}, true).stream()
                .map(File::getAbsolutePath)
                .collect(Collectors.toList());
        Configuration config = new Configuration(new File(KARATE_OUTPUT_PATH), "api");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

}
