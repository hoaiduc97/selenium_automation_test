package lab_12.models.pages;

import lab_12.models.components.FooterComponent;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private final WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public FooterComponent footerComponent(){
        return new FooterComponent(this.driver);
    }
}
