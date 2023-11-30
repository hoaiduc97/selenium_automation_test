package web_automation.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.driver.DriverFactory;
import web_automation.models.components.global.footer.CustomerServiceColumnComponent;
import web_automation.models.components.global.footer.FooterColumnComponent;
import web_automation.models.components.global.footer.FooterComponent;
import web_automation.models.components.global.footer.InformationColumnComponent;
import web_automation.models.pages.HomePage;

public class FooterComponentTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://demowebshop.tricentis.com/");
        try {
            HomePage homePage = new HomePage(driver);
            FooterComponent footerComponent = homePage.footerComponent();
            InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComponent();
            testFooterComp(informationColumnComponent);
            CustomerServiceColumnComponent customerServiceColumnComponent = footerComponent.customerServiceColumnComponent();
            testFooterComp(customerServiceColumnComponent);
        } catch (Exception ignored) {

        } finally {
            driver.quit();
        }

    }

    private static void testFooterComp(FooterColumnComponent footerColumnComponent) {
        System.out.println(footerColumnComponent.headerEle().getText());
        for (WebElement linkEle : footerColumnComponent.linkEle()) {
            System.out.println(linkEle.getText() + ": " + linkEle.getAttribute("href"));
        }
        System.out.println("=====");
    }
}
