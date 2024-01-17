package web_automation.tests.global.footer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import web_automation.test_flow.global.FooterTestFlow;
import web_automation.tests.BaseTest;

public class FooterTest extends BaseTest {
    @Test
    public void testHomepageFooter(){
        WebDriver driver =getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }
    @Test
    public void testCategoryPageFooter(){
        WebDriver driver = getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyProductCatFooterComponent();
    }
}
