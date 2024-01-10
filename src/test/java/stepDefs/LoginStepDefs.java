package stepDefs;

import Readers.property.PropertyReader;
import _pageObjects.PageObjects;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class LoginStepDefs extends BaseSteps {
    PageObjects loginObjects;
    @Given("user on homepage")
    public void userOnHomepage() {
        loginObjects = new PageObjects();
        String url = PropertyReader.read().get("url");
        driver.get(url);
    }

    @When("user clicks My Account Link")
    public void userClicksMyAccountLink() {
        click(loginObjects.menuMyAccountLink);
    }

    @And("user clicks login link")
    public void userClicksLoginLink() {
        click(loginObjects.menuLoginLink);
    }

    @Then("Login page should be visible")
    public void loginPageShouldBeVisible() {
        waitForVisibility(loginObjects.loginFormUsername);
    }

    @When("user fill the login form with the following datas")
    public void userFillTheLoginFormWithTheFollowingDatas(DataTable table) {
        Map<String,String> map = table.asMap();

        sendKeys(loginObjects.loginFormUsername,map.get("username"));

        sendKeys(loginObjects.loginFormPassword, map.get("password"));
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        click(loginObjects.loginFormSubmitButton);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccesfull() {
        waitForVisibility(loginObjects.sideBarLogout);
    }


    @Then("login should not be succesfull")
    public void loginShouldNotBeSuccesfull() {
        waitForVisibility(loginObjects.invalidWarning);
    }


    @When("user clicks the following links with text")
    public void userClicksTheFollowingLinksWithText(DataTable table) {
        String xpathOfLink = "//a[contains(., '%s')]";
        List<String> list = table.asList();
        for(String s : list){
            By locator = By.xpath(String.format(xpathOfLink, s));
            click(locator);
        }
    }

    @Then("login should be {string}")
    public void loginShouldBe(String status) {
        if(status.equalsIgnoreCase("true")){
            waitForVisibility(loginObjects.sideBarLogout);
        }else{
            waitForVisibility(loginObjects.invalidWarning);
        }
    }

    @When("user login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        click(loginObjects.menuMyAccountLink);
        click(loginObjects.menuLoginLink);
        waitForVisibility(loginObjects.loginFormUsername);
        sendKeys(loginObjects.loginFormUsername,username);
        sendKeys(loginObjects.loginFormPassword, password);
        click(loginObjects.loginFormSubmitButton);
    }
}
