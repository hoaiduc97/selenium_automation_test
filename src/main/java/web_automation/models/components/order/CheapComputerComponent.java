package web_automation.models.components.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(".product-essential")
public class CheapComputerComponent extends ComputerEssentialComponent {
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        System.out.println("selectProcessorType CHEAP");
        return null;
    }

    @Override
    public String selectRAMType(String type) {
        System.out.println("selectRAMType CHEAP");
        return null;
    }
}
