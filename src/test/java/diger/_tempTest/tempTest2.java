package diger._tempTest;

import Readers.property.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
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

        for (int i = 0; i < menuElements.size(); i++) {
            menuElements = driver.findElements(mainMenu);
            new  Actions(driver).moveToElement(menuElements.get(i));

            List<WebElement> subElements = menuElements.get(i).findElements(By.xpath(".//div//li"));

            for (int j = 0; j < subElements.size(); j++) {
                waitForVisibility(subElements.get(i));
                menuElements = driver.findElements(mainMenu);
                new  Actions(driver).moveToElement(menuElements.get(i));
                subElements = menuElements.get(i).findElements(By.xpath(".//div//li"));
            }
         }
            driver.close();
    }
}