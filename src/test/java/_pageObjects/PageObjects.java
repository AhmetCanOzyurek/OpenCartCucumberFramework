package _pageObjects;

import driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageObjects {

    public PageObjects() {
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
    @FindBy(css = "#search input")
    public WebElement eTopSerachBox;
    @FindBy(css = "#search button")
    public WebElement eTopSearchSubmitButton;
    @FindBy(css = "#search input")
    public WebElement eSearchContainer;
    @FindBy(css = "div.alert.alert-success")
    public WebElement eSuccessAlert;
    @FindBy(xpath = "//div[@id='top-links']//a[contains(.,'Shopping')]")
    public WebElement eTopBarCart;
    @FindBy(xpath = "//button[@data-original-title='Remove']")
    public WebElement lRemoveButton;
    @FindBy(xpath = "//div[@class='product-thumb']")
    public List<WebElement> eListedProducts;

    @FindBy(xpath = "//div[@id='cart']//button[not(@title)]")
    public WebElement eBodyCartButton;

    @FindBy(css = ".dropdown-menu table")
    public WebElement eCartFirstTable;

}
