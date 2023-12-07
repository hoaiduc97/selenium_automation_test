package web_automation.tests.order.computer;

import org.testng.annotations.Test;
import web_automation.models.components.order.StandardComputerComponent;
import web_automation.test_flow.computer.OrderComputerFlow;
import web_automation.tests.BaseTest;

public class BuyingStandardComputerTest extends BaseTest {
    @Test
    public void testBuyingStandardComputer(){
        driver.get("https://demowebshop.tricentis.com/build-your-own-computer");
        OrderComputerFlow orderComputerFlow = new OrderComputerFlow<>(driver, StandardComputerComponent.class);
        orderComputerFlow.buildCompSpecAndAddToCart();
    }
}
