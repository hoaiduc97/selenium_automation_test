package web_automation.models.components.global.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;
import web_automation.models.components.global.footer.CustomerServiceColumnComponent;
import web_automation.models.components.global.footer.InformationColumnComponent;
import web_automation.models.components.product.ProductItemComponent;

@ComponentCSSSelector(value = ".footer")
public class FooterComponent extends Component {

    public FooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public InformationColumnComponent informationColumnComponent() {
        return findComponent(InformationColumnComponent.class);
    }

    public ProductItemComponent productItemComponent() {
        return findComponent(ProductItemComponent.class);
    }

    public CustomerServiceColumnComponent customerServiceColumnComponent(){
        return findComponent(CustomerServiceColumnComponent.class);
    }

    public MyAccountColumnComponent myAccountColumnComponent(){
        return findComponent(MyAccountColumnComponent.class);
    }

    public FollowUsComponent followUsComponent(){
        return findComponent(FollowUsComponent.class);
    }
}
