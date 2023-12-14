package web_automation.tests.order.computer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web_automation.models.components.order.StandardComputerComponent;
import web_automation.test_data.ComputerData;
import web_automation.test_data.DataObjectBuilder;
import web_automation.test_flow.computer.OrderComputerFlow;
import web_automation.tests.BaseTest;

public class BuyingStandardComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testBuyingStandardComputer(ComputerData computerData ){
        driver.get("https://demowebshop.tricentis.com/build-your-own-computer");
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerData);
        orderComputerFlow.buildCompSpec();
        orderComputerFlow.addItemToCart();
        orderComputerFlow.verifyShoppingCartPage();
    }

    @DataProvider()
    public ComputerData[] computerData(){
        String relativeComputerLocation = "/src/main/java/web_automation/test_data/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectForm(relativeComputerLocation, ComputerData[].class);
    }
}
