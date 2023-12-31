package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver extends driverFactory {
    private static WebDriver driver;
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {
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
        return drivers.get();
    }



    public static void quitDriver(){
        if(drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
