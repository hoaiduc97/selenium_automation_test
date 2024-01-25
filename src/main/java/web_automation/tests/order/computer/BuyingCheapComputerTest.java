package web_automation.tests.order.computer;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import web_automation.models.components.order.CheapComputerComponent;
import web_automation.test_data.CreditCardType;
import web_automation.test_data.PaymentMethod;
import web_automation.test_data.computer.ComputerData;
import web_automation.test_data.DataObjectBuilder;
import web_automation.test_flow.computer.OrderComputerFlow;
import web_automation.tests.BaseTest;

public class BuyingCheapComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testBuyingCheapComputer(ComputerData computerData) {
        WebDriver driver = getDriver();
        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerData);
        orderComputerFlow.buildCompSpec();
        orderComputerFlow.addItemToCart();
        orderComputerFlow.verifyShoppingCartPage();
        orderComputerFlow.agreeTOSAndCheckout();
        orderComputerFlow.inputBillingAddress();
        orderComputerFlow.inputShippingAddress();
        orderComputerFlow.selectShippingMethod();
        orderComputerFlow.selectPaymentMethod(PaymentMethod.CREDIT_CARD);
        orderComputerFlow.inputPaymentInfo(CreditCardType.DISCOVER);
        orderComputerFlow.confirmOrder();
    }

    @DataProvider()
    public ComputerData[] computerData() {
        String relativeComputerLocation = "/src/main/java/web_automation/test_data/computer/CheapComputerDataList.json";
        return DataObjectBuilder.buildDataObjectForm(relativeComputerLocation, ComputerData[].class);
    }
}
