package web_automation.test_flow.computer;

import org.openqa.selenium.WebDriver;
import web_automation.models.components.cart.TotalComponent;
import web_automation.models.components.order.ComputerEssentialComponent;
import web_automation.models.pages.ComputerItemDetailPage;
import web_automation.models.pages.ShoppingCartPage;
import web_automation.test_data.ComputerData;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerFlow<T extends ComputerEssentialComponent> {

    private Class<T> computerEssentialCompClass;
    private WebDriver driver;
    private ComputerData computerData;
    private double itemTotalPrice;
    private int quantity;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialCompClass, ComputerData computerData) {
        this.computerEssentialCompClass = computerEssentialCompClass;
        this.driver = driver;
        this.computerData = computerData;
        this.quantity = 1;
    }

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialCompClass, ComputerData computerData, int quantity) {
        this.computerEssentialCompClass = computerEssentialCompClass;
        this.driver = driver;
        this.computerData = computerData;
        this.quantity = quantity;
    }

    public void buildCompSpec() {
        ComputerEssentialComponent computerEssentialComponent = new ComputerItemDetailPage(driver).computerComp(computerEssentialCompClass);
        computerEssentialComponent.unselectDefaultOptions();
        String processorFullStr = computerEssentialComponent.selectProcessorType(this.computerData.getProcessor());
        double processorAdditionalPrice = extractAdditionalPrice(processorFullStr);
        String ramFullStr = computerEssentialComponent.selectRAMType(this.computerData.getRam());
        double ramAdditionalPrice = extractAdditionalPrice(ramFullStr);
        String hddFullStr = computerEssentialComponent.selectHDD(this.computerData.getHdd());
        double hddAdditionalPrice = extractAdditionalPrice(hddFullStr);
        String softwareFullStr = computerEssentialComponent.selectHDD(this.computerData.getSoftware());
        double softwareAdditionalPrice = extractAdditionalPrice(softwareFullStr);
        double osAdditionalPrice = 0;
        String osDataOption = this.computerData.getOS();
        if(osDataOption != null){
            String osFullStr = computerEssentialComponent.selectOS(osDataOption);
            osAdditionalPrice = extractAdditionalPrice(osFullStr);
        }
        double additionalPrice = processorAdditionalPrice + ramAdditionalPrice + hddAdditionalPrice +softwareAdditionalPrice + osAdditionalPrice;

        // Set item quantity
        computerEssentialComponent.setProductQuantity(this.quantity);

        // Calculate the item price = Base price + Additional price
        this.itemTotalPrice = (computerEssentialComponent.productPrice() + additionalPrice) * this.quantity;
    }

    public void addItemToCart(){
        ComputerItemDetailPage computerItemDetailPage = new ComputerItemDetailPage(driver);
        ComputerEssentialComponent computerEssentialComp = computerItemDetailPage.computerComp(computerEssentialCompClass);
        computerEssentialComp.clickOnAddToCartBtn();
        computerEssentialComp.waitUntilItemAddedToCard();
        computerItemDetailPage.headerComponent().clickShoppingCartLink();
    }
    public void verifyShoppingCartPage(){
        ShoppingCartPage shoppingCartPage  = new ShoppingCartPage(driver);
        TotalComponent totalComponent = shoppingCartPage.totalComponent();
        Map<String, Double> priceCategories = totalComponent.priceCategories();
        for(String priceType : priceCategories.keySet()){
            System.out.printf("%s, %f\n", priceType, priceCategories.get(priceType));
        }
    }

    private double extractAdditionalPrice(String optionStr) {
        double price = 0;
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(optionStr);
        if (matcher.find()) {
            price = Double.parseDouble(matcher.group(1).replaceAll("[+-]", ""));
        }
        return price;
    }
}





