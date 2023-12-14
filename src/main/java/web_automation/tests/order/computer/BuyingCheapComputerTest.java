package web_automation.tests.order.computer;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web_automation.models.components.order.CheapComputerComponent;
import web_automation.test_data.ComputerData;
import web_automation.test_data.DataObjectBuilder;
import web_automation.test_flow.computer.OrderComputerFlow;
import web_automation.tests.BaseTest;

public class BuyingCheapComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testBuyingCheapComputer(ComputerData computerData){
       driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
       OrderComputerFlow<CheapComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerData);
       orderComputerFlow.buildCompSpec();
       orderComputerFlow.addItemToCart();
       orderComputerFlow.verifyShoppingCartPage();
    }

    @DataProvider()
    public ComputerData[] computerData(){
        String relativeComputerLocation = "/src/main/java/web_automation/test_data/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectForm(relativeComputerLocation, ComputerData[].class);
    }
}
