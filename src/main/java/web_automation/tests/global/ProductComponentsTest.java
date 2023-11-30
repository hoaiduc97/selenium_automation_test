package web_automation.tests.global;

import org.openqa.selenium.WebDriver;
import web_automation.driver.DriverFactory;
import web_automation.models.pages.HomePage;

public class ProductComponentsTest {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get("https://demowebshop.tricentis.com/");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.productItemComponentList().forEach(productItemComponent -> {
                System.out.println(productItemComponent.productTitleEle().getText());
            });
        } catch (Exception ignored) {

        } finally {
            driver.quit();
        }
    }
}
