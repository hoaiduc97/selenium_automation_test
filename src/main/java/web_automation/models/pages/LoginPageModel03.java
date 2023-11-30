package web_automation.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageModel03 {
    private final WebDriver webDriver;
    private final By USERNAME_SEL = By.id("");
    private final By PASSWORD_SEL = By.id("");
    private final By LOGIN_BTN_SEL = By.id("");

    public LoginPageModel03(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPageModel03 inputUsername(String usernameStr) {
       this.webDriver.findElement(USERNAME_SEL).sendKeys(usernameStr);
       return this;
    }

    public LoginPageModel03 inputPassword(String passwordStr) {
        this.webDriver.findElement(PASSWORD_SEL).sendKeys(passwordStr);
        return this;
    }

    public void clickOnLoginBtn() {
        this.webDriver.findElement(LOGIN_BTN_SEL).click();
    }
}
