package web_automation.models.components.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import web_automation.models.components.Component;
import web_automation.models.components.ComponentCSSSelector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentCSSSelector(".cart-footer .totals")
public class TotalComponent extends Component {
    private static final By priceTableRowSel = By.cssSelector("table tr");
    private static final By priceTypeRowSel = By.cssSelector(".cart-total-left");
    private static final By priceValueRowSel = By.cssSelector(".cart-total-right");

    public TotalComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    /*
    * <Sub-total, 1365>
    * <Shipping, 0>
    <Tax, 0>
    * <Total, 1365>
    */

    public Map<String, Double> priceCategories() {
        Map<String, Double> priceCategories = new HashMap<>();
        List<WebElement> priceTableRowEles = findElements(priceTableRowSel);
        Assert.assertFalse(priceTableRowEles.isEmpty(), "[ERR] Price table is empty");
        for (WebElement tableRowEle : priceTableRowEles) {
            WebElement priceTypeEle = tableRowEle.findElement(priceTypeRowSel);
            WebElement priceValueEle = tableRowEle.findElement(priceValueRowSel);

            // Key, Value
            String priceType = priceTypeEle.getText().replace(":", "").trim();
            double priceValue = Double.parseDouble(priceValueEle.getText().trim());
            priceCategories.put(priceType, priceValue);
        }
        return priceCategories;
    }
}
