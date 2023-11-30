package web_automation.api_learning;

import web_automation.support.ui.WaitForElementEnable;
import web_automation.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl {
    // Declare constants
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/dynamic_controls";
    private static final By CHECKBOX_FORM_SEL = By.cssSelector("#checkbox-example");
    private static final By INPUT_FORM_SEL = By.cssSelector("#input-example");
    private static final By CHECK_INPUT_ELE_SEL = By.cssSelector("#checkbox-example input");
    private static final By INPUT_FIELD_ELE = By.cssSelector("#input-example input");
    private static final By BTN_ELE_SEL = By.tagName("button");



    // main method
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Locate 2 parent forms
            WebElement checkboxFormEle = driver.findElement(CHECKBOX_FORM_SEL);
            WebElement inputFormEle = driver.findElement(INPUT_FORM_SEL);

            // Check box form interact
            WebElement removeBtnEle = checkboxFormEle.findElement(BTN_ELE_SEL);
            WebElement checkBoxEle  = checkboxFormEle.findElement(CHECK_INPUT_ELE_SEL);
            System.out.println("BEFORE | is element selected: " + checkBoxEle.isSelected());
            checkBoxEle.click();
            System.out.println("AFTER | is element selected: " + checkBoxEle.isSelected());

            //
            removeBtnEle.click();
            wait.until(ExpectedConditions.invisibilityOf(checkBoxEle));

            // input form interact
            WebElement enableFieldBtn  = inputFormEle.findElement(BTN_ELE_SEL);
            WebElement textFieldEle = inputFormEle.findElement(INPUT_FIELD_ELE);
            System.out.println("BEFORE | is element enable: " + textFieldEle.isEnabled());
            enableFieldBtn.click();
            wait.until(new WaitForElementEnable(INPUT_FIELD_ELE));
            System.out.println("AFTER | is element enable: " + textFieldEle.isEnabled());
            textFieldEle.sendKeys("Input text!!");

            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
