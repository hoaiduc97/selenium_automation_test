package web_automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getWebDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        // Workaround for not enable manager password pop-up
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Add wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
        return driver;
    }
}
