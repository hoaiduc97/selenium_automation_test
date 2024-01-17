package web_automation.models.components.order;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class ComputerEssentialComponent extends BaseItemComponent {
    private static final By allOptionsSel = By.cssSelector(".option-list input");

    public ComputerEssentialComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    @Step("Select processor type: {type}")
    public abstract String selectProcessorType(String type);
    @Step("Select RAM type: {type}")
    public abstract String selectRAMType(String type);
    @Step("Select HDD type: {type}")
    public String selectHDD(String type) {
        return selectCompOption(type);
    }
    @Step("Select OS type: {type}")
    public String selectOS(String type){
        return selectCompOption(type);
    }
    @Step("Select software type: {type}")
    public String selectSoftware(String type){
        return selectCompOption(type);
    }
    @Step("Unselecting all default options")
    public void unselectDefaultOptions(){
        component.findElements(allOptionsSel).forEach(option -> {
            if(option.getAttribute("checked") != null){
                option.click();
            }
        });
    }
    @Step("Select option with value: {type}")
    protected String selectCompOption(String type) {
        String selectorStr = "//label[contains(text()," + "\"" + type + "\"" + ")]";
        By optionSelector = By.xpath(selectorStr);
        WebElement optionEle = null;
        try {
            optionEle = component.findElement(optionSelector);
        } catch (Exception ignored){

        }
        if(optionEle == null){
            throw new RuntimeException("[ERR] The option " + type + "is not existing to select!");
        }
        optionEle.click();
        return optionEle.getText().trim();
    }
}
