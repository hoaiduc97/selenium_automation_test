package web_automation.models.components.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(".cart-item-row")
public class CartItemRowComponent extends Component {
    private static final By unitPriceSel = By.cssSelector(".product-unit-price");
    private static final By itemQuantitySel = By.cssSelector("input[name^='itemquantity']");
    private static final By subtotalSel = By.cssSelector(".product-subtotal");

    public CartItemRowComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public double unitPrice(){
        return Double.parseDouble(findElement(unitPriceSel).getText().trim());
    }

    public double itemQuantity(){
        return Double.parseDouble(findElement(itemQuantitySel).getAttribute("value").trim());
    }

    public double subTotal(){
        return Double.parseDouble(findElement(subtotalSel).getText().trim());
    }
}
