package web_automation.models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(value = ".header")
public class HeaderComponent extends Component {
    private static final By shoppingCartLinkSel = By.id("topcartlink");

    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickShoppingCartLink(){
        findElement(shoppingCartLinkSel).click();
    }
}
