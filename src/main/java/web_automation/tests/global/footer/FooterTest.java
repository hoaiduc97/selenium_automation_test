package web_automation.tests.global.footer;

import org.openqa.selenium.WebDriver;
import web_automation.driver.DriverFactory;
import web_automation.test_flow.global.FooterTestFlow;

public class FooterTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://demowebshop.tricentis.com/");
        try {
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
