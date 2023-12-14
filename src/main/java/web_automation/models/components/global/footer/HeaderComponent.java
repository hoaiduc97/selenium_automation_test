package web_automation.models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;

import java.time.Duration;

@ComponentCSSSelector(value = ".header")
public class HeaderComponent extends Component {
    private static final By shoppingCartLinkSel = By.id("topcartlink");

    public HeaderComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickShoppingCartLink(){
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLinkSel));
        //findElement(shoppingCartLinkSel).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(shoppingCartLinkSel)).click().build().perform();
    }
}
