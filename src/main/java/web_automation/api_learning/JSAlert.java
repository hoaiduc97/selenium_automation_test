package web_automation.api_learning;

import web_automation.driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSAlert {
    // Declare constants
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final By JS_ALERT_BTN = By.cssSelector("[onclick='jsAlert()']");
    private static final By JS_CONFIRM_BTN = By.cssSelector("[onclick='jsConfirm()']");
    private static final By JS_PROMPT_BTN   = By.cssSelector("[onclick='jsPrompt()']");
    private static final By RESULT_TEXT_SEL   = By.cssSelector("#result");

    // main method
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            WebElement resultEle = driver.findElement(RESULT_TEXT_SEL);
            // Interact with JSAlert
            handleJSAlert(driver, JS_ALERT_BTN, true);
            System.out.println(resultEle.getText());
            Thread.sleep(2000);

            // Interact with JSConfirm
            handleJSAlert(driver, JS_CONFIRM_BTN, true);
            System.out.println(resultEle.getText());
            Thread.sleep(2000);

            // Interact with JSPrompt
            handleJSAlert(driver, JS_PROMPT_BTN, true, "abc");
            System.out.println(resultEle.getText());
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
    private static void handleJSAlert(WebDriver driver, By triggerBtn, boolean isAccepting, String... message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(triggerBtn).click();
        Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
        if(message.length>0){
            jsAlert.sendKeys(message[0]);
            makeAlertDecision(jsAlert, isAccepting);
        }else {
            makeAlertDecision(jsAlert, isAccepting);
        }

    }

    private static void makeAlertDecision(Alert jsAlert, boolean isAccepting){
        if(isAccepting){
            jsAlert.accept();
        }else{
            jsAlert.dismiss();
        }
    }
}
