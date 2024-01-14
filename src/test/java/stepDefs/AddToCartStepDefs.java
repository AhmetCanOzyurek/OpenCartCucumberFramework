package stepDefs;

import _pageObjects.PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class AddToCartStepDefs extends BaseSteps {
    PageObjects pageObjects = new PageObjects();
    List<WebElement> removeButtons;
    @When("Clean the Cart")
    public void cleanTheCart() {
        click(pageObjects.eTopBarCart);
        By emptyText = By.xpath("(//p[text()='Your shopping cart is empty!'])[2]");
       waitForVisibility(emptyText);
        removeButtons = driver.findElements(By.xpath("//button[@data-original-title='Remove']"));
        while (!removeButtons.isEmpty()){
            click(pageObjects.lRemoveButton);
            removeButtons =driver.findElements(By.xpath("//button[@data-original-title='Remove']"));
        }
    }

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
        removeButtons = driver.findElements(By.xpath("//button[@data-original-title='Remove']"));
        Assert.assertEquals(removeButtons.size(),0);
        wait.until(ExpectedConditions.invisibilityOfAllElements(removeButtons));
    }

    @When("user add {string} to the Cart")
    public void userAddToTheCart(String product) {
        clickButtonOfListedProduct(product,Buttons.cart);
//        WebElement productThumb = pageObjects.eListedProducts.stream().filter(e-> e.getText().contains(product)).collect(Collectors.toList()).get(0);
//        new Actions(driver).moveToElement(productThumb).perform();
//        productThumb.findElement(By.xpath("(//button)[1]")).click();
    }

    @Then("success notification with {string} should be visible")
    public void successNotificationWithShouldBeVisible(String text) {
        waitForVisibility(pageObjects.eSuccessAlert);
        Assert.assertTrue(pageObjects.eSuccessAlert.getText().toLowerCase().contains(text.toLowerCase()));
    }

    @And("product {string} should be listed in Cart")
    public void productShouldBeListedInCart(String product) {
        waitForVisibility(pageObjects.eCartFirstTable);
        Assert.assertTrue(pageObjects.eCartFirstTable.getText().contains(product));

    }

    @When("user add all products to the Cart")
    public void userAddAllProductsToTheCart() {
        for (WebElement eListedProduct : pageObjects.eListedProducts) {
            eListedProduct.findElement(By.xpath(".//button[contains(.,'Add to Cart')]")).click();
            waitForVisibility(pageObjects.eSuccessAlert);
        }
    }

    @And("save products names into {string}")
    public void saveProductsNamesInto(String fileName) {

    }

    @Then("all listed products should be listed in Cart")
    public void allListedProductsShouldBeListedInCart() {
    }

    @And("user change navigate to Cart")
    public void userChangeNavigateToCart() {
    }

    @And("user change the quantity of {string} as {int}")
    public void userChangeTheQuantityOfAsQuantity(String name,int quantity) {
    }

    @Then("quantity should be updated")
    public void quantityShouldBeUpdated() {
    }

}
