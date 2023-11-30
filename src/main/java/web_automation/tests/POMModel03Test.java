package web_automation.tests;

import web_automation.driver.DriverFactory;
import web_automation.models.pages.LoginPageModel03;
import org.openqa.selenium.WebDriver;

public class POMModel03Test {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https:\\");
        LoginPageModel03 loginPageModel03 = new LoginPageModel03(driver);
        loginPageModel03.inputUsername("teo123")
                .inputPassword("password123")
                .clickOnLoginBtn();
    }
}
