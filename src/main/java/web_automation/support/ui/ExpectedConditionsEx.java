package web_automation.support.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ExpectedConditionsEx {
    public static ExpectedCondition<List<WebElement>> presenceOfAllElementsLocatedBy(final WebElement parentComp, final By locator){
        return new ExpectedCondition<List<WebElement>>(){
            @Override
            public List<WebElement> apply(WebDriver driver){
                List<WebElement> elements = parentComp.findElements(locator);
                return elements.size() > 0 ? elements : null;
            }

            @Override
            public String toString(){
                return "presence of all elements located by" + locator;
            }
        };

    }
}
