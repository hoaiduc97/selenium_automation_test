package web_automation.tests;

import web_automation.driver.DriverFactory;
import web_automation.models.pages.LoginPageModel01;
import org.openqa.selenium.WebDriver;

public class POMModel01Test {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("");
        LoginPageModel01 loginPageModel01 = new LoginPageModel01(driver);
        loginPageModel01.username().sendKeys("teo@smith");
        loginPageModel01.password().sendKeys("abc123");
        loginPageModel01.loginBtn().click();
    }
}
