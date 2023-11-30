package web_automation.models.components.global.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(".column.my-account")
public class MyAccountColumnComponent extends FooterColumnComponent{
    public MyAccountColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
