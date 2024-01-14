package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/AddToCart.feature"},
        glue = {"stepDefs"},
        tags = "@Tag"
)
public class RunnerAddToCart extends AbstractTestNGCucumberTests {
}
