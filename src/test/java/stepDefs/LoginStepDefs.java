package stepDefs;

import Readers.PropertyReader;
import _pageObjects.LoginObjects;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.devtools.v85.network.model.LoadingFinished;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.Properties;

public class LoginStepDefs extends BaseSteps {
    LoginObjects loginObjects;
    @Given("user on homepage")
    public void userOnHomepage() {
        loginObjects = new LoginObjects();
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
        Map<String,String> map =table.asMap();

        sendKeys(loginObjects.loginFormUsername,map.get("username"));

        sendKeys(loginObjects.loginFormPassword, map.get("password"));
        Assert.fail();
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        click(loginObjects.loginFormSubmitButton);
    }

    @Then("login should be succesfull")
    public void loginShouldBeSuccesfull() {
        waitForVisibility(loginObjects.sideBarLogout);
    }


    @Then("login should not be succesfull")
    public void loginShouldNotBeSuccesfull() {
        waitForVisibility(loginObjects.invalidWarning);

    }
}
