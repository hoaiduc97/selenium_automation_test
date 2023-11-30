package web_automation.api_learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();

        // Open web page
        webDriver.get("https://www.google.com.vn/");

        // Quit browser
        webDriver.close();
    }
}
