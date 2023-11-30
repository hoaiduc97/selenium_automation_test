package web_automation.models.components.global.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(".column.follow-us")
public class FollowUsComponent extends FooterColumnComponent{
    public FollowUsComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

}
