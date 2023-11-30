package web_automation.test_flow.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import web_automation.models.components.global.footer.FooterColumnComponent;
import web_automation.models.components.global.footer.InformationColumnComponent;
import web_automation.models.pages.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComponent() {
        BasePage basePage = new BasePage(this.driver);
        InformationColumnComponent informationColumnComponent = basePage.footerComponent().informationColumnComponent();
        verifyInformationColumn(informationColumnComponent);
    }

    private void verifyInformationColumn(FooterColumnComponent informationColumnComponent) {
        List<String> expectedLinkTexts = Arrays.asList("Sitemap", "Shipping & Returns", "Privacy Note", "Condition of Use", "About us", "Contact Us");
        List<String> expectedHrefs = Arrays.asList("/sitemap", "/shipping & returns", "/privacy-note", "/condition-of-use", "/about-us", "/contact-us");
        testFooterColumn(informationColumnComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyCustomerServiceColumn(FooterColumnComponent customerServiceComponent) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        testFooterColumn(customerServiceComponent, expectedLinkTexts, expectedHrefs);
    }

    private void verifyMyAccountColumn(FooterColumnComponent myAccountColumn) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        testFooterColumn(myAccountColumn, expectedLinkTexts, expectedHrefs);
    }

    private void verifyFollowUsColumn(FooterColumnComponent followUsColumn) {
        List<String> expectedLinkTexts = new ArrayList<>();
        List<String> expectedHrefs = new ArrayList<>();
        testFooterColumn(followUsColumn, expectedLinkTexts, expectedHrefs);
    }

    private void testFooterColumn(FooterColumnComponent footerColumnComponent, List<String> expectedLinkTexts, List<String> expectedHrefs) {
        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualHrefs = new ArrayList<>();
        expectedHrefs.replaceAll(originHref -> "https://demowebshop.tricentis.com/" + originHref);
        footerColumnComponent.linkEle().forEach(columnItem -> {
            actualHrefs.add(columnItem.getAttribute("href"));
            actualLinkTexts.add(columnItem.getText());
        });
        if (actualLinkTexts.isEmpty() || actualHrefs.isEmpty()) {
            Assert.fail("Footer column text OR hyper link is empty!");
        }
        Assert.assertEquals(actualLinkTexts, expectedLinkTexts, "[ERR] Footer column link texts are different");
        Assert.assertEquals(actualHrefs, expectedHrefs, "[ERR] Footer column link hrefs are different");
    }

}
