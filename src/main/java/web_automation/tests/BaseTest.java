package web_automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import web_automation.driver.DriverFactory;

public class BaseTest {
    protected static WebDriver driver;
    @BeforeTest
    protected void initBrowserSection(){
        driver = DriverFactory.getWebDriver();
    }

    @AfterTest
    public void closeBrowserSection(){
        if(driver != null){
            driver.quit();
        }
    }
}
