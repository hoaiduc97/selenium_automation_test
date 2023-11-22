package lab_12.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageModel02 {
    private final WebDriver webDriver;
    private final By USERNAME_SEL = By.id("");
    private final By PASSWORD_SEL = By.id("");
    private final By LOGIN_BTN_SEL = By.id("");

    public LoginPageModel02(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void inputUsername(String usernameStr) {
        this.webDriver.findElement(USERNAME_SEL).sendKeys(usernameStr);
    }

    public void inputPassword(String passwordStr) {
        this.webDriver.findElement(PASSWORD_SEL).sendKeys(passwordStr);
    }

    public void clickOnLoginBtn() {
        this.webDriver.findElement(LOGIN_BTN_SEL).click();
    }
}
