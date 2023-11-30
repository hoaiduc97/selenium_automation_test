package web_automation.test_flow.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.global.footer.FooterColumnComponent;
import web_automation.models.components.global.footer.InformationColumnComponent;
import web_automation.models.pages.BasePage;

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

    }

    private void verifyCustomerServiceColumn() {

    }

    private void verifyMyAccountColumn() {

    }

    private void verifyFollowUsColumn() {

    }

    private void testFooterColumn(FooterColumnComponent footerColumnComponent) {
        System.out.println(footerColumnComponent.headerEle().getText());
        for (WebElement linkEle : footerColumnComponent.linkEle()) {
            System.out.println(linkEle.getText() + ":" + linkEle.getAttribute("href"));
        }
        System.out.println("====");
    }

}
