package lab_12.api_learning;

import lab_12.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrameInteraction {
    // Declare constants
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/iframe";
    private static final By IFRAME = By.cssSelector("iframe[id^='mce']");

    // main method
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);
        try {
            WebElement iFrameEle = driver.findElement(IFRAME);

            //Switch to iframe element
            driver.switchTo().frame(iFrameEle);

            // Interact with iframe element
            WebElement  inputField = driver.findElement(By.id("tinymce"));
            inputField.click();
            inputField.clear();
            inputField.sendKeys("Interact with iframe successful!!");
            Thread.sleep(2000);

            // Switch back after interact
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
