package web_automation.models.components.global.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.Component;

import java.util.List;

public class FooterColumnComponent extends Component {
    private static final By HEADER_SEL = By.tagName("h3");
    private static final By LINK_SEL = By.cssSelector("li a");


    public FooterColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement headerEle() {
        return this.component.findElement(HEADER_SEL);
    }

    public List<WebElement> linkEle() {
        return this.component.findElements(LINK_SEL);
    }

}
