package web_automation.models.pages;

import org.openqa.selenium.WebDriver;
import web_automation.models.components.cart.CartItemRowComponent;
import web_automation.models.components.cart.TotalComponent;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    List<CartItemRowComponent> cartItemRowComps(){
        return findComponents(CartItemRowComponent.class);
    }

    public TotalComponent totalComponent (){
        return findComponent(TotalComponent.class);
    }
}
