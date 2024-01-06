package TestNG;

import driver.Driver;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import stepDefs.BaseSteps;

import static utils.Utils.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class WishListScenarioWithJSON extends BaseSteps {
    @Test
    public void LoginTest() {
        driver.get(getValue("application", "url"));
        click(getBy("topmenu", "myaccount"));
        click(getBy("topmenu", "loginlink"));
        sendKeys(getBy("login", "username"), getValue("application", "username"));
        sendKeys(getBy("login", "password"), getValue("application", "password"));
        click(getBy("login", "submitbutton"));
        Assert.assertTrue(driver.findElement(getBy("search", "esuccesalert")).getText().toLowerCase().contains("wish list!"));
    }

@Test(dependsOnMethods = "LoginTest")
        public void searchTest() {
    sendKeys(getBy("search", "etopsearchbox"), "iMac");
    click(getBy("search", "etopsearchsubmitbutton"));
    waitForVisibility(getBy("search", "esearchcontainer"));
}
@Test(dependsOnMethods = "searchTest")
public void addToWishList(){
        click(getXpathOfButtonOfListedProduct("iMac",Buttons.wish));
        waitForVisibility(getBy("search","esuccesalert"));
    }







}
