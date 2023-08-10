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

//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @Test(dataProvider = "features")
//    public void runCucumberTest(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
//
//    @DataProvider(name = "features")
//    public Object[][] features() {
//        return testNGCucumberRunner.provideFeatures();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        testNGCucumberRunner.finish();
//    }
}
