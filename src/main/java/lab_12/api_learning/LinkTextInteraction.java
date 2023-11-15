package lab_12.api_learning;

import lab_12.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextInteraction {
    // Declare constants
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/login";

    // main method
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            By partialLinkTextSel = By.partialLinkText("Selenium");
            By linkTextSel = By.linkText("Elemental Selenium");
            WebElement poweredByLinkTextEle = driver.findElement(linkTextSel);
            WebElement partialLinkTextEle = driver.findElement(partialLinkTextSel);
            partialLinkTextEle.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
