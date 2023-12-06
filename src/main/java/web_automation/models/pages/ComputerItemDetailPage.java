package web_automation.models.pages;

import org.openqa.selenium.WebDriver;
import web_automation.models.components.order.ComputerEssentialComponent;

public class ComputerItemDetailPage extends BasePage{
    public ComputerItemDetailPage(WebDriver driver) {
        super(driver);
    }

    public <T extends ComputerEssentialComponent> T computerComp(Class<T> computerEssentialCompClass){
        return findComponent(computerEssentialCompClass);
    }
}
