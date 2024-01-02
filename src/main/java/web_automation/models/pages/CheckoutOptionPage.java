package web_automation.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOptionPage extends BasePage{

    private static final By checkoutAsGuestBtn = By.cssSelector("input[class*='checkout-as-guest-button']");

    public CheckoutOptionPage(WebDriver driver) {
        super(driver);
    }

    public void checkoutAsGuest(){
        findElement(checkoutAsGuestBtn).click();
    }
}
