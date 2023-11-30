package web_automation.api_learning;

import web_automation.support.ui.WaitForElementEnable;
import web_automation.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {
    // Declare constants
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";

    // main method
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            //webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("taolao")));
            webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("taolao"))));

            // Using customize explicit wait
            webDriverWait.until(new WaitForElementEnable(By.cssSelector("#sth")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
