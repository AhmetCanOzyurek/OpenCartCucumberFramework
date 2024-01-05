package stepDefs;

import _pageObjects.PageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchSteps extends BaseSteps{
    PageObjects pageObjects = new PageObjects();

    @Given("user search for {string}")
    public void userSearchFor(String textToSearch) {
        sendKeys(pageObjects.eTopSerachBox, textToSearch);
        click(pageObjects.eTopSearchSubmitButton);
        waitForVisibility(pageObjects.eSearchContainer);
        getXpathOfButtonOfListedProduct("iMac", Buttons.wish);
        getXpathOfButtonOfListedProduct("iMac", 2);
        getXpathOfButtonOfListedProduct("iMac", "wish");


    }

    @When("user add {string} to the wishList")
    public void userAddToTheWishList(String productName) {
        click(getXpathOfButtonOfListedProduct(productName,Buttons.wish));
    }



    @Then("successs notification with {string} should be visible")
    public void successsNotificationWithShouldBeVisible(String text) {
        waitForVisibility(pageObjects.eSuccessAlert);
        Assert.assertTrue(pageObjects.eSuccessAlert.getText().toLowerCase().contains(text.toLowerCase()));
    }
}
