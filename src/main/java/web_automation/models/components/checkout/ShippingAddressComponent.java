package web_automation.models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector("#opc-shipping")
public class ShippingAddressComponent extends Component {

    private static final By continueBtnSel = By.cssSelector("input[class*='new-address-next-step-button']");

    public ShippingAddressComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickOnContinueBtn() {
        findElement(continueBtnSel).click();
    }
}
