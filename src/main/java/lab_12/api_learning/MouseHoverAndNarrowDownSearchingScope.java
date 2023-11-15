package lab_12.api_learning;

import lab_12.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

public class MouseHoverAndNarrowDownSearchingScope {
    // Declare constants
    private static final String TARGET_URL = "https://the-internet.herokuapp.com/hovers";
    private static final By FIGURE_SEL = By.cssSelector(".figure");
    private static final By FIGURE_NAME_SEL = By.cssSelector(".figcaption h5");
    private static final By FIGURE_LINK_SEL = By.cssSelector(".figcaption a");

    // main method
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getWebDriver();
        driver.get(TARGET_URL);

        try {
            List<WebElement> elementList = driver.findElements(FIGURE_SEL);
            if (elementList.isEmpty()) {
                throw new NoSuchElementException("No figures in the page");
            }
            // Mouse hover action
            Actions actions = new Actions(driver);

            for (WebElement figureEle : elementList) {
                // Finding child elements
                WebElement profileNameEle = figureEle.findElement(FIGURE_NAME_SEL);
                WebElement profileLinkEle = figureEle.findElement(FIGURE_LINK_SEL);
                boolean isProfileNameDisplayed = profileNameEle.isDisplayed();
                boolean isProfileLinkDisplay = profileLinkEle.isDisplayed();
                System.out.println("BEFORE | Is profile name display: " + isProfileNameDisplayed);
                System.out.println("BEFORE | Is profile link display: " + isProfileLinkDisplay);

                actions.moveToElement(figureEle).perform();
                isProfileNameDisplayed = profileNameEle.isDisplayed();
                isProfileLinkDisplay = profileLinkEle.isDisplayed();
                System.out.println("AFTER | Is profile name display: " + isProfileNameDisplayed);
                System.out.println("AFTER | Is profile link display: " + isProfileLinkDisplay);
                System.out.println("Profile name is: " + profileNameEle.getText());
                System.out.println("Profile link is: " + profileLinkEle.getAttribute("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
