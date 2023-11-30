package web_automation.models.pages;

import org.openqa.selenium.WebDriver;
import web_automation.models.components.product.ProductItemComponent;

import java.util.List;

public class HomePage extends BasePage{
    protected final WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Selectors

    // Methods
    public List<ProductItemComponent> productItemComponentList(){
        return findComponents(ProductItemComponent.class);
    }

}
