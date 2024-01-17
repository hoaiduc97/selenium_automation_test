package web_automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;
    public static WebDriver getWebDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        // Workaround for not enable manager password pop-up
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Add wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
        return driver;
    }

    public WebDriver getDriver(){
        if(driver == null){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            this.driver = new ChromeDriver(chromeOptions);
        }
        return this.driver;

    }

    public void closeBrowserSession(){
        if(driver != null){
            driver.quit();
        }
    }
}
