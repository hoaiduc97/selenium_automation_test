package web_automation.models.components.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent{
    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        System.out.println("selectProcessorType STANDARD");
        return null;
    }

    @Override
    public String selectRAMType(String type) {
        System.out.println("selectRAMType STANDARD");
        return null;
    }
}
