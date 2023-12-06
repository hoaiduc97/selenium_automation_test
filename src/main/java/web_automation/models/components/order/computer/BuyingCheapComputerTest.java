package web_automation.models.components.order.computer;

import org.testng.annotations.Test;
import web_automation.models.components.order.CheapComputerComponent;
import web_automation.test_flow.computer.OrderComputerFlow;
import web_automation.tests.BaseTest;

public class BuyingCheapComputerTest extends BaseTest {
    @Test
    public void testBuyingCheapComputer(){
        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
        OrderComputerFlow orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class);
        orderComputerFlow.buildCompSpecAndAddToCart();
    }
}
