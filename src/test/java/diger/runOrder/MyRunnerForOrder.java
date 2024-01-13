package diger.runOrder;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = {"src/test/java/Diger/runOrder/RunOrder.feature"},
        glue = {"diger/runOrder"}
)
public class MyRunnerForOrder extends BaseRunner{
}
