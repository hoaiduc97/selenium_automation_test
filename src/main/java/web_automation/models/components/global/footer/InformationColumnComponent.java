package web_automation.models.components.global.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;
import web_automation.models.components.global.footer.FooterColumnComponent;

@ComponentCSSSelector(".column.information")
public class InformationColumnComponent extends FooterColumnComponent {

    public InformationColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
