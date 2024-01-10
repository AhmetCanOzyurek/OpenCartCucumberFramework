package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import jdk.jshell.execution.Util;
import org.testng.annotations.BeforeTest;
import utils.Utils;

@CucumberOptions(
        features = {"src/test/resources/features/featuresFromExcel/testCaseFromExcel.feature"},
        glue = {"stepDefs"},
        plugin = { "pretty",
                "json: test-output/cucumber-reports/cucumber.json",
                "html: test-output/cucumber-reports/cucumberReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class runnerExcell extends AbstractTestNGCucumberTests {
    @BeforeTest
    public void beforeTest(){
        String fileExcel = "src/test/resources/datafiles/testCase.xlsx";
        String fileFeature = "src/test/resources/features/featuresFromExcel/testCaseFromExcel.feature";

        Utils.createFeatureFileFromExcel(fileExcel, fileFeature);
    }


}
