package web_automation.tests;

import org.openqa.selenium.WebDriver;
import web_automation.driver.DriverFactory;
import web_automation.models.pages.HomePage;

public class POMModel04Test {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();

        HomePage homePage = new HomePage(driver);
    }
}
