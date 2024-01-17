package web_automation.models.components.order;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;

@ComponentCSSSelector(".product-essential")
public class CheapComputerComponent extends ComputerEssentialComponent {
    public CheapComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Step("Select processor type: {type}")
    @Override
    public String selectProcessorType(String type) {
        return selectCompOption(type);
    }
    @Step("Select RAM: {type}")
    @Override
    public String selectRAMType(String type) {
        return selectCompOption(type);
    }
}
