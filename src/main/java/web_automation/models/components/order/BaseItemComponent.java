package web_automation.models.components.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.Component;

public class BaseItemComponent extends Component {
    private static final By productPriceSel = By.cssSelector(".product-price");
    private static final By addToCartBtn = By.cssSelector("input[id^='add-to-card-button']");

    public BaseItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double productPrice(){
        String productPriceStr = findElement(productPriceSel).getText().trim();
        return Double.parseDouble(productPriceStr);
    }

    public void clickOnAddToCartBtn(){
        findElement(addToCartBtn).click();
    }
}
