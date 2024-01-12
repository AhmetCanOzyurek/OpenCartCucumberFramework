package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//TestNG ile Cucumber'in anlasmasini saglayan CucumberOptions
@CucumberOptions(
        //features = {"src/test/resources/features"}, //features altindaki tum feature dosyalarini run eder
        features = {"src/test/resources/features/Login.feature", "src/test/resources/features/Login2.feature"},
        glue = {"stepDefs", "hooks"},
        plugin = {"pretty",
                "json: cucumber-reports/cucumber.json",  //cucumber json report
                "html: cucumber-reports/cucumber.html",  //cucumber html report
        },  //ozellikle rapor icin kullanilir
        dryRun = true //sadece stepDefs'lerin dogru tanimlanip tanimlanmadigini kontrol eder, run etmez


)
public class RunnerParallel extends AbstractTestNGCucumberTests {

}

/*
runner class TestNG'ye aittir
TestNG ile Cucumber'in anlasmasini saglayan CucumberOptions
 */
