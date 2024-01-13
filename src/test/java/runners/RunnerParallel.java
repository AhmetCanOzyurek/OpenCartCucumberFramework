package runners;

import driver.Browsers;
import driver.Driver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

//TestNG ile Cucumber'in anlasmasini saglayan CucumberOptions
@CucumberOptions(
        //features = {"src/test/resources/features"}, //features altindaki tum feature dosyalarini run eder
        features = {"src/test/resources/features/Wishlist.feature" },
        glue = {"stepDefs", "hooks"},
        plugin = {"pretty",
                "json: cucumber-reports/cucumber.json",  //cucumber json report
                "html: cucumber-reports/cucumber.html",  //cucumber html report
        }  //ozellikle rapor icin kullanilir
//        dryRun = true //sadece stepDefs'lerin dogru tanimlanip tanimlanmadigini kontrol eder, run etmez
)
public class RunnerParallel extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("chrome") String browser) {
        Driver.getDriver(Browsers.valueOf(browser.toUpperCase()));
    }
}


