package web_automation.models.pages;

import org.openqa.selenium.By;
import web_automation.models.components.Component;
import web_automation.models.components.global.CategoryItemComponent;
import web_automation.models.components.global.footer.FooterComponent;
import org.openqa.selenium.WebDriver;
import web_automation.models.components.global.footer.HeaderComponent;

import java.util.List;

public class BasePage extends Component {
    protected final WebDriver driver;


    public BasePage(WebDriver driver) {
        super(driver, driver.findElement(By.tagName("html")));
        this.driver = driver;
    }

    public FooterComponent footerComponent(){
        return findComponent(FooterComponent.class);
    }

    public HeaderComponent headerComponent(){
        return findComponent(HeaderComponent.class);
    }

    public List<CategoryItemComponent> categoryItemComponents(){
        return findComponents(CategoryItemComponent.class);
    }
}
