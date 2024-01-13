package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver extends driverFactory {
    private static WebDriver driver;
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> waits = new ThreadLocal<>();
    private static ThreadLocal<Browsers> browsers = new ThreadLocal<>();
    public static WebDriver getDriver() {
        if(browsers.get()==null)
        browsers.set(Browsers.CHROME);

        return getDriver(browsers.get());
    }

    public static WebDriver getDriver(Browsers browser) {
//      if(browsers.get() == null)
        // Cucumber @After'da Driver.quitDriver(); oldugundan her senaryo farkli bir browser ile run edilebilir
        //Driver.quitDriver() yapilmamis ise browser degisse'de driver()==null olmadigi icin browser degismez
        browsers.set(browser);
        //if(driver == null){
        if (drivers.get() == null){
            switch (browser) {
                case SAFARI:
                    drivers.set(createSafari());
                    break;
                case FIREFOX:
                    drivers.set(createFirefox());
                    break;
                case EDGE:
                    drivers.set(createEdge());
                    break;
                default:
                    drivers.set(createChrome());
                    break;
            }
    }
        waits.set(new WebDriverWait(drivers.get(), Duration.ofSeconds(10)));
        return drivers.get();
    }
    public static WebDriverWait getWait(){
        return waits.get();
    }


    public static void quitDriver(){
        if(drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
