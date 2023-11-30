package web_automation.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageModel01 {
    private final WebDriver webDriver;
    private final By USERNAME_SEL = By.id("");
    private final By PASSWORD_SEL = By.id("");
    private final By LOGIN_BTN_SEL = By.id("");

    public LoginPageModel01(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public WebElement username(){
        return this.webDriver.findElement(USERNAME_SEL);
    }

    public WebElement password(){
        return this.webDriver.findElement(PASSWORD_SEL);
    }

    public WebElement loginBtn(){
        return this.webDriver.findElement(LOGIN_BTN_SEL);
    }
}
