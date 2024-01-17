package web_automation.models.components.order;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web_automation.models.components.Component;

public class BaseItemComponent extends Component {

    private static final By barNotificationSel = By.id("bar-notification");
    private static final By headerAddToCartLinkSel = By.cssSelector("#bar-notification a");
    private static final By productPriceSel = By.cssSelector(".product-price");
    private static final By productQuantitySel = By.cssSelector(".add-to-cart input[class^='qty-input']");

    private static final By addToCartBtn = By.cssSelector("input[id^='add-to-cart-button']");

    public BaseItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickAddToCartLink(){
        findElement(headerAddToCartLinkSel).click();
    }
    @Step("Getting product price")
    public double productPrice(){
        String productPriceStr = findElement(productPriceSel).getText().trim();
        return Double.parseDouble(productPriceStr);
    }
    @Step("Buying with quantity: {quantity}")
    public void setProductQuantity(int quantity){
        findElement(productQuantitySel).clear();
        findElement(productQuantitySel).sendKeys(String.valueOf(quantity));
    }
    @Step("Click on cart button")
    public void clickOnAddToCartBtn(){
        findElement(addToCartBtn).click();
    }

    @Step("Wait until item add to cart")
    public void waitUntilItemAddedToCard(){
        String successMsg = "The product has been added to your shopping cart";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(barNotificationSel, successMsg));
    }
}
