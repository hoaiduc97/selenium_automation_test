package web_automation.models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;
import web_automation.test_data.CreditCardType;

@ComponentCSSSelector("#opc-payment_info")
public class PaymentInformationComponent extends Component {

    private static final By creditCardDropDownSel = By.id("CreditCardType");
    private static final By cardHolderNameSel = By.id("CardholderName");
    private static final By cardNumberSel = By.id("CardNumber");
    private static final By cardExpireMonthDropDownSel = By.id("ExpireMonth");
    private static final By cardExpireYearDropDownSel = By.id("ExpireYear");
    private static final By cardCodeSel = By.id("CardCode");
    private static final By purchaseOrderNumSel = By.id("PurchaseOrderNumber");
    private static final By continueBtnSel = By.cssSelector("input[class*='payment-info-next-step-button']");

    public PaymentInformationComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectCardType(CreditCardType creditCardType) {
        Assert.assertNotNull(creditCardType, "[ERR] Credit card type can't be null");
        Select select = new Select(findElement(creditCardDropDownSel));
        switch (creditCardType) {
            case VISA:
                select.selectByVisibleText("Visa");
                break;
            case MASTER_CARD:
                select.selectByVisibleText("Master card");
                break;
            case AMEX:
                select.selectByVisibleText("Amex");
                break;
            case DISCOVER:
                select.selectByVisibleText("Discover");
                break;
        }
    }

    public void inputCardHolderName(String name) {
        findElement(cardHolderNameSel).sendKeys(name);
    }

    public void inputCardNumber(String number) {
        findElement(cardNumberSel).sendKeys(number);
    }

    public void inputExpireMonth(String month) {
        Select select = new Select(findElement(cardExpireMonthDropDownSel));
        select.selectByVisibleText(month);
    }

    public void inputExpireYear(String year) {
        Select select = new Select(findElement(cardExpireYearDropDownSel));
        select.selectByVisibleText(year);
    }

    public void inputCardCode(String code) {
        findElement(cardCodeSel).sendKeys(code);
    }

    public void inputPurchaseNum(String purchaseNum) {
        findElement(purchaseOrderNumSel).sendKeys(purchaseNum);
    }

    public void clickOnContinueBtn() {
        findElement(continueBtnSel).click();
        wait.until(ExpectedConditions.invisibilityOf(findElement(continueBtnSel)));
    }
}
