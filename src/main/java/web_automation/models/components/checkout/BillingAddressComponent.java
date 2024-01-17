package web_automation.models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector("#opc-billing")
public class BillingAddressComponent extends Component {

    private static final By inputAddressDropDownSel = By.id("billing-address-select");
    private static final By firstNameSel = By.id("BillingNewAddress_FirstName");
    private static final By lastNameSel = By.id("BillingNewAddress_LastName");
    private static final By emailSel = By.id("BillingNewAddress_Email");
    private static final By companySel = By.id("BillingNewAddress_Company");
    private static final By selectCountryDropDownSel = By.id("BillingNewAddress_CountryId");
    private static final By selectStateDropDownSel = By.id("BillingNewAddress_StateProvinceId");
    private static final By loadingStateProgressBarSel = By.id("states-loading-progress");
    private static final By citySel = By.id("BillingNewAddress_City");
    private static final By address1Sel = By.id("BillingNewAddress_Address1");
    private static final By zipCodeSel = By.id("BillingNewAddress_ZipPostalCode");
    private static final By phoneNumberSel = By.id("BillingNewAddress_PhoneNumber");
    private static final By faxNumberSel = By.id("BillingNewAddress_FaxNumber");
    private static final By continueBtnSel = By.cssSelector("input[class*='button-1 new-address-next-step-button']");

    public BillingAddressComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectInputNewAdd(){
        if(!findElements(inputAddressDropDownSel).isEmpty()){
            Select select = new Select(findElement(inputAddressDropDownSel));
            select.selectByVisibleText("New Address");
        }
    }

    public void inputFirstName(String firstname){
        findElement(firstNameSel).sendKeys(firstname);
    }

    public void inputLastName(String lastName){
        findElement(lastNameSel).sendKeys(lastName);
    }

    public void inputEmail(String email){
        findElement(emailSel).sendKeys(email);
    }

    public void selectCountry(String country){
        selectCommon(findElement(selectCountryDropDownSel), country);
        wait.until(ExpectedConditions.invisibilityOf(findElement(loadingStateProgressBarSel)));
    }

    public void selectState(String state){
        selectCommon(findElement(selectStateDropDownSel), state);
    }

    private void selectCommon(WebElement dropdownEle, String value){
        Select select = new Select(dropdownEle);
        select.selectByVisibleText(value);
    }
    public void inputCity(String city){
        findElement(citySel).sendKeys(city);
    }

    public void inputAddress1(String add1){
        findElement(address1Sel).sendKeys(add1);
    }


    public void inputZipCode(String zipCode){
        findElement(zipCodeSel).sendKeys(zipCode);
    }

    public void inputPhoneNumber(String phoneNumber){
        findElement(phoneNumberSel).sendKeys(phoneNumber);
    }

    public void clickOnContinueBtn(){
        findElement(continueBtnSel).click();
        wait.until(ExpectedConditions.invisibilityOf(findElement(continueBtnSel)));
    }
}
