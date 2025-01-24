package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target/rerun.txt",  // Specifies the location of the rerun file with failed tests
        glue = "stepDefinitions",        // Specifies the package containing step definitions
        plugin = {
                "pretty",                     // Generates a pretty formatted console output
                "html:target/cucumber-report.html", // Generates an HTML report
                "json:target/cucumber.json",  // Generates a JSON report
                "rerun:target/rerun.txt"      // This will create a file for rerunning failed tests
        },
        monochrome = true                 // Improves the readability of console output
)
public class Rerun extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)   // Enables parallel execution of test scenarios
    public Object[][] scenarios() {
        return super.scenarios();     // Calls the parent method to get all scenarios
    }
}