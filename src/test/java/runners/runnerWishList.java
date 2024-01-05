package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefs"},
        tags = "@WishList"
       /* plugin = { "pretty",
                "json: test-output/cucumber-reports/cucumber.json",
                "html: test-output/cucumber-reports/cucumberReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}*/
)
public class runnerWishList extends AbstractTestNGCucumberTests {


}
