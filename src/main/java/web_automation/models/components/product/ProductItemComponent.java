package web_automation.models.components.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(value = ".product-item")
public class ProductItemComponent extends Component {

    private static final By PRODUCT_TITLE_SEL = By.tagName("h2");
    public ProductItemComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public WebElement productTitleEle(){
        return this.findElement(PRODUCT_TITLE_SEL);
    }
}
