package stepDefs;

import driver.Driver;
import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;


public class BaseSteps {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BaseSteps() {
        driver = Driver.getDriver();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait = Driver.getWait();
    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    public void click(WebElement element) {
        wait.until(driver1 -> {
            try {
                element.click();
                return true;
            } catch (Exception e1) {
                try {
                    new Actions(driver1).moveToElement(element).click().perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].click", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(driver1 -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e1) {
                try {
                    element.clear();
                    new Actions(driver1).moveToElement(element).sendKeys(text).perform();
                    return true;
                } catch (Exception e2) {
                    try {
                        element.clear();
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].value='" + text + "'", element);
                        return true;
                    } catch (Exception e3) {
                        return false;
                    }
                }
            }
        });
    }

    public void waitForVisibility(WebElement elemenet) {
        wait.until(ExpectedConditions.visibilityOf(elemenet));
    }
    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static By getXpathOfButtonOfListedProduct(String text, String button){
        int index = 3;
        if(button.equalsIgnoreCase("wish")) index = 2;
        if(button.equalsIgnoreCase("cart")) index = 1;
        return By.xpath("//div[@class='product-thumb' and .//div[@class='caption' and .//*[contains(.,'" + text + "')]]]//button["+index+"]");
    }  public static By getXpathOfButtonOfListedProduct(String text, int index){

        return By.xpath("//div[@class='product-thumb' and .//div[@class='caption' and .//*[contains(.,'" + text + "')]]]//button["+index+"]");
    }
    public static By getXpathOfButtonOfListedProduct(String text, Buttons button){

        int index = button.ordinal()+1;

        return By.xpath("//div[@class='product-thumb' and .//div[@class='caption' and .//*[contains(.,'" + text + "')]]]//button["+index+"]");
    }

    public enum Buttons {
        cart,
        wish,
        compare;
    }

    public void clickButtonOfListedProduct(String text, Buttons button){
        click(getXpathOfButtonOfListedProduct(text,button));
    }
}
