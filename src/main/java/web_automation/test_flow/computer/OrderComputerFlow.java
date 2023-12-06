package web_automation.test_flow.computer;

import org.openqa.selenium.WebDriver;
import web_automation.models.components.order.ComputerEssentialComponent;
import web_automation.models.pages.ComputerItemDetailPage;

public class OrderComputerFlow <T extends ComputerEssentialComponent>{

    private Class<T> computerEssentialCompClass;
    private WebDriver driver;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialCompClass){
        this.computerEssentialCompClass = computerEssentialCompClass;
        this.driver = driver;
    }

    public void buildCompSpecAndAddToCart(){
        ComputerEssentialComponent computerEssentialComponent = new ComputerItemDetailPage(driver).computerComp(computerEssentialCompClass);
        computerEssentialComponent.selectProcessorType("processor");
        computerEssentialComponent.selectRAMType("RAM");

        // Other step
    }
}
