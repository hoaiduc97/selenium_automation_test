package web_automation.tests;

import web_automation.driver.DriverFactory;
import web_automation.models.pages.LoginPageModel02;
import org.openqa.selenium.WebDriver;

public class POMModel02Test {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https:\\");
        LoginPageModel02 loginPageModel02 = new LoginPageModel02(driver);
        loginPageModel02.inputUsername("teo123");
        loginPageModel02.inputPassword("password123");
        loginPageModel02.clickOnLoginBtn();
    }
}
