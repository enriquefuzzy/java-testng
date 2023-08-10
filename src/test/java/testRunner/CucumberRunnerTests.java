package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// These are used when running `mvn clean test`
// Can be overridden to use specific Cucumber tags in the mvn command
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepDefinitions"
)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
