package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"src/test/java/features"}, glue = {"src/test/java/steps"}, monochrome = true, plugin = { "html:target/cucumber-html-reports","pretty",
        "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt" }
)

public class TestRunner {

//tags = {@LoginTestCases};
} 