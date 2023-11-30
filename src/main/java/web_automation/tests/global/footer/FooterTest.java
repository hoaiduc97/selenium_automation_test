package web_automation.tests.global.footer;

import org.testng.annotations.Test;
import web_automation.test_flow.global.FooterTestFlow;
import web_automation.tests.BaseTest;

public class FooterTest extends BaseTest {
    @Test
    public void testHomepageFooter(){
        driver.get("https://demowebshop.tricentis.com/");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }
}
