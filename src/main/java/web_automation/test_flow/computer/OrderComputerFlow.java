package web_automation.test_flow.computer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import web_automation.models.components.cart.CartItemRowComponent;
import web_automation.models.components.cart.TotalComponent;
import web_automation.models.components.checkout.*;
import web_automation.models.components.order.ComputerEssentialComponent;
import web_automation.models.pages.CheckoutOptionPage;
import web_automation.models.pages.CheckoutPage;
import web_automation.models.pages.ComputerItemDetailPage;
import web_automation.models.pages.ShoppingCartPage;
import web_automation.test_data.CreditCardType;
import web_automation.test_data.DataObjectBuilder;
import web_automation.test_data.PaymentMethod;
import web_automation.test_data.computer.ComputerData;
import web_automation.test_data.user.UserDataObject;

import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OrderComputerFlow<T extends ComputerEssentialComponent> {

    private Class<T> computerEssentialCompClass;
    private WebDriver driver;
    private ComputerData computerData;
    private double itemTotalPrice;
    private int quantity;
    private UserDataObject defaultCheckoutUser;
    private PaymentMethod paymentMethod;
    private CreditCardType creditCardType;

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
        if (osDataOption != null) {
            String osFullStr = computerEssentialComponent.selectOS(osDataOption);
            osAdditionalPrice = extractAdditionalPrice(osFullStr);
        }
        double additionalPrice = processorAdditionalPrice + ramAdditionalPrice + hddAdditionalPrice + softwareAdditionalPrice + osAdditionalPrice;

        // Set item quantity
        computerEssentialComponent.setProductQuantity(this.quantity);

        // Calculate the item price = Base price + Additional price
        this.itemTotalPrice = (computerEssentialComponent.productPrice() + additionalPrice) * this.quantity;
    }

    public void addItemToCart() {
        ComputerItemDetailPage computerItemDetailPage = new ComputerItemDetailPage(driver);
        ComputerEssentialComponent computerEssentialComp = computerItemDetailPage.computerComp(computerEssentialCompClass);
        computerEssentialComp.clickOnAddToCartBtn();
        computerEssentialComp.waitUntilItemAddedToCard();
        computerItemDetailPage.headerComponent().clickShoppingCartLink();
    }

    public void verifyShoppingCartPage() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        List<CartItemRowComponent> cartItemRowComps = shoppingCartPage.cartItemRowComps();
        // Verify shopping cart details
        Assert.assertFalse(cartItemRowComps.isEmpty(), "[ERR] There is no item displayed in the shopping cart!");
        double currentSubTotals = 0;
        double currentTotalUnitPrices = 0;
        for (CartItemRowComponent cartItemRowComp : cartItemRowComps) {
            currentSubTotals += cartItemRowComp.subTotal();
            currentTotalUnitPrices = currentTotalUnitPrices + (cartItemRowComp.itemQuantity() * cartItemRowComp.unitPrice());
        }
        Assert.assertEquals(currentSubTotals, currentTotalUnitPrices, "[ERR] shopping cart sub-total is incorrect");
        // Verify checkout prices
        TotalComponent totalComponent = shoppingCartPage.totalComponent();
        Map<String, Double> priceCategories = totalComponent.priceCategories();
        Assert.assertFalse(priceCategories.keySet().isEmpty(), "[ERR] Checkout price info is empty!");
        double checkoutSubTotal = 0;
        double checkoutTotal = 0;
        double checkoutOtherFees = 0;

        for (String priceType : priceCategories.keySet()) {
            double priceValue = priceCategories.get(priceType);
            if (priceType.startsWith("Sub-Total")) {
                checkoutSubTotal = priceValue;
            } else if (priceType.startsWith("Total")) {
                checkoutTotal = priceValue;
            } else {
                checkoutOtherFees = checkoutOtherFees + priceValue;
            }
        }
        Assert.assertEquals(currentSubTotals, checkoutSubTotal, "[ERR] Checkout Sub-Total is incorrect");
        Assert.assertEquals(checkoutTotal, (checkoutTotal + checkoutOtherFees), "[ERR] Checkout Total is incorrect");
    }

    public void agreeTOSAndCheckout() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        TotalComponent totalComp = shoppingCartPage.totalComponent();
        totalComp.agreeTOS();
        totalComp.clickOnCheckoutBtn();

        // This is exception case, please do not use one flow method for more than one page
        new CheckoutOptionPage(driver).checkoutAsGuest();
    }

    public void inputBillingAddress() {
        String defaultCheckoutUserDataLOC = "/src/main/java/web_automation/test_data/user/DefaultCheckoutUser.json";
        this.defaultCheckoutUser = DataObjectBuilder.buildDataObjectForm(defaultCheckoutUserDataLOC, UserDataObject.class);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        BillingAddressComponent billingAddressComp = checkoutPage.billingAddressComponent();
        billingAddressComp.selectInputNewAdd();
        billingAddressComp.inputFirstName(defaultCheckoutUser.getFirstName());
        billingAddressComp.inputLastName(defaultCheckoutUser.getLastName());
        billingAddressComp.inputEmail(defaultCheckoutUser.getEmail());
        billingAddressComp.selectCountry(defaultCheckoutUser.getCountry());
        billingAddressComp.selectState(defaultCheckoutUser.getState());
        billingAddressComp.inputCity(defaultCheckoutUser.getCity());
        billingAddressComp.inputAddress1(defaultCheckoutUser.getAdd1());
        billingAddressComp.inputZipCode(defaultCheckoutUser.getZipcode());
        billingAddressComp.inputPhoneNumber(defaultCheckoutUser.getPhoneNumber());
        billingAddressComp.clickOnContinueBtn();
    }

    public void inputShippingAddress() {
        new CheckoutPage(driver).shippingAddressComponent().clickOnContinueBtn();
    }

    public void selectShippingMethod() {
        List<String> shippingMethods = Arrays.asList("Ground", "Next Day Air", "2nd Day Air");
        int randomShippingMethodIndex = new SecureRandom().nextInt(shippingMethods.size());
        String randomShippingMethod = shippingMethods.get(randomShippingMethodIndex);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ShippingMethodComponent shippingMethodComp = checkoutPage.shippingMethodComponent();
        shippingMethodComp.selectShippingMethod(randomShippingMethod);
        shippingMethodComp.clickOnContinueBtn();
    }

    public void selectPaymentMethod() {
        this.paymentMethod = PaymentMethod.COD;
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentMethodComponent paymentMethodComp = checkoutPage.paymentMethodComponent();
        paymentMethodComp.selectCODMethod();
    }

    public void selectPaymentMethod(PaymentMethod paymentMethod) {
        Assert.assertNotNull(paymentMethod, "[ERR] Payment method type can't be null");
        this.paymentMethod = paymentMethod;
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentMethodComponent paymentMethodComponent = checkoutPage.paymentMethodComponent();
        switch (paymentMethod) {
            case CHECK_MONEY_ORDER:
                paymentMethodComponent.selectCheckMoneyOrderMethod();
                break;
            case PURCHASE_ORDER:
                paymentMethodComponent.selectPurchaseOrderMethod();
                break;
            case CREDIT_CARD:
                paymentMethodComponent.selectCreditCardMethod();
                break;
            default:
                paymentMethodComponent.selectCODMethod();
        }
        paymentMethodComponent.clickOnContinueBtn();
    }

    public void inputPaymentInfo(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        PaymentInformationComponent paymentInformationComp = checkoutPage.paymentInformationComponent();
        if (this.paymentMethod.equals(PaymentMethod.PURCHASE_ORDER)) {
            paymentInformationComp.inputPurchaseNum("123");
        } else if (this.paymentMethod.equals(PaymentMethod.CREDIT_CARD)) {
            paymentInformationComp.selectCardType(creditCardType);
            String cardHolderFirstName = this.defaultCheckoutUser.getFirstName();
            String cardHolderLastName = this.defaultCheckoutUser.getLastName();
            paymentInformationComp.inputCardHolderName(cardHolderLastName + " " + cardHolderFirstName);
            //Trigger the logic for other card types as well like Amex...
            String cardNumber = creditCardType.equals(CreditCardType.VISA) ? "4012888888881881" : "6011000990139424";
            paymentInformationComp.inputCardNumber(cardNumber);

            // Current month and year
            Calendar calendar = new GregorianCalendar();
            paymentInformationComp.inputExpireMonth(String.valueOf(calendar.get(Calendar.MONTH) + 1));
            paymentInformationComp.inputExpireYear(String.valueOf(calendar.get(Calendar.YEAR) + 1));
            paymentInformationComp.inputCardCode("123");
            paymentInformationComp.clickOnContinueBtn();
        } else if (this.paymentMethod.equals(PaymentMethod.COD)) {
            // Verify the text is [You will pay by COD]
        } else {
            // Verify the text is [Mail Personal or Business Check, Cashier's Check or money order to:....]
        }
    }

    // TODO: if you have time please add verification methods for this
    public void confirmOrder() {
        new CheckoutPage(driver).confirmOrderComponent().clickOnConfirmBtn();
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





