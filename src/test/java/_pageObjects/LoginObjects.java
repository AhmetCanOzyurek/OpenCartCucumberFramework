package _pageObjects;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefs.LoginStepDefs;

public class LoginObjects {

    public LoginObjects(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id = 'top-links']//a[contains(.,'My Account')]")
        public WebElement menuMyAccountLink;

    @FindBy(xpath = "//div[@id = 'top-links']//a[contains(.,'Login')]")
    public WebElement menuLoginLink;
    @FindBy(id = "input-email")
    public WebElement loginFormUsername;
    @FindBy(id = "input-password")
    public WebElement loginFormPassword;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginFormSubmitButton;
    @FindBy(xpath = "//aside[@id='column-right']//*[.='Logout']")
    public WebElement sideBarLogout;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement invalidWarning;
}
