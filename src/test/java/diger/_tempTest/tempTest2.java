package diger._tempTest;

import Readers.property.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import stepDefs.BaseSteps;

import java.util.List;

public class tempTest2 extends BaseSteps {
    By mainMenu = By.xpath("//ul[@class='nav navbar-nav']/li");

    @Test
    public void hoverOverMenu() {
        String url = PropertyReader.read().get("url");
        driver.get(url);
        List<WebElement> menuElements = driver.findElements(mainMenu);

        for (WebElement element : menuElements) {

            new Actions(driver).moveToElement(element).perform();
            List<WebElement> subMenuElements = element.findElements(By.xpath(".//div//li"));
            for (WebElement subMenuElement : subMenuElements) {
                new Actions(driver).moveToElement(subMenuElement).click().perform();
                driver.navigate().refresh();
                waitForVisibility(element);
                menuElements = driver.findElements(mainMenu);
            }
        }
        driver.close();
    }
}
