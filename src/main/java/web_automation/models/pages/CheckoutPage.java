package web_automation.models.pages;

import org.openqa.selenium.WebDriver;
import web_automation.models.components.checkout.BillingAddressComponent;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public BillingAddressComponent billingAddressComponent(){
        return findComponent(BillingAddressComponent.class);
    }
}
