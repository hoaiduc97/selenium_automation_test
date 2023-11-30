package web_automation.models.components.global.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(".column.customer-service")
public class CustomerServiceColumnComponent extends FooterColumnComponent {
    public CustomerServiceColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
