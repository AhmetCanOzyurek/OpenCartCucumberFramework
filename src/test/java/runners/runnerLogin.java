package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue = {"stepDefs"},
        tags = "@login1",
        plugin = { "pretty",
                "json: test-output/cucumber-reports/cucumber.json",
                "html: test-output/cucumber-reports/cucumberReport.html"}
)
public class runnerLogin extends AbstractTestNGCucumberTests {
}
