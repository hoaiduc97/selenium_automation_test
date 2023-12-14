package web_automation.models.components.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web_automation.models.components.ComponentCSSSelector;
import web_automation.support.ui.SelectEx;

import java.util.List;

@ComponentCSSSelector(".product-essential")
public class StandardComputerComponent extends ComputerEssentialComponent{
    private static final By productAttrSel = By.cssSelector("select[name^='product_attribute']");

    public StandardComputerComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    @Override
    public String selectProcessorType(String type) {
        final int PROCESSOR_DROPDOWN_INDEX = 0;
        WebElement processorDropdownEle = component.findElements(productAttrSel).get(PROCESSOR_DROPDOWN_INDEX);
        return selectOption(processorDropdownEle, type);
    }

    @Override
    public String selectRAMType(String type) {
        final int RAM_DROPDOWN_INDEX = 1;
        WebElement ramDropdownEle = component.findElements(productAttrSel).get(RAM_DROPDOWN_INDEX);
        return selectOption(ramDropdownEle, type);
    }

    public String selectOption(WebElement dropdownEle, String type){
        SelectEx selectEx = new SelectEx(dropdownEle);
        List<WebElement> allOptionsEle = selectEx.getOptions();
        String fullStrOptions = null;

        for(WebElement optionEle : allOptionsEle){
            String currentOptionText = optionEle.getText();
            String optionTextWithoutSpace = currentOptionText.trim().replace(" ", "");
            if(optionTextWithoutSpace.startsWith(type)){
                fullStrOptions = currentOptionText;
                break;
            }
        }
        if(fullStrOptions == null){
            throw new RuntimeException("[ERR] The option " + type + "is not existing to select");
        }
        selectEx.selectByVisibleText(fullStrOptions);
        return fullStrOptions;
    }

}
