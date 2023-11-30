package web_automation.api_learning;

import web_automation.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class FormInteractionWithMultipleMatching {
    // Declare constants
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";
    private static final By LOGIN_BTN_FIELD_SEL = By.tagName("input");
    private static final By LOGIN_BTN_SEL = By.cssSelector("#login [type='submit']");


    // main method
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);
        try {
            List<WebElement> elementList = driver.findElements(LOGIN_BTN_FIELD_SEL);
            if (!elementList.isEmpty()) {
                final int USERNAME_INDEX = 0;
                final int PASSWORD_INDEX = 1;
                elementList.get(USERNAME_INDEX).sendKeys("tomsmith!");
                elementList.get(PASSWORD_INDEX).sendKeys("supersecretpassword");
            } else {
                throw new NoSuchElementException("No login fields found!!");
            }
            driver.findElement(LOGIN_BTN_SEL).click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
