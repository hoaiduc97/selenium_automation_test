package web_automation.tests;

import io.qameta.allure.Allure;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.input.Input;
import org.testng.FileAssert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import web_automation.driver.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest
    protected void initBrowserSection() {
        driver = DriverFactory.getWebDriver();
    }

    @AfterTest
    public void closeBrowserSection() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void captureScreenShot(ITestResult result) {
        boolean isTestFailed = result.getStatus() == ITestResult.FAILURE;
        if (isTestFailed) {
            attachScreenshotToReport(result);
        }
    }

    private void attachScreenshotToReport(ITestResult result){
        // testMethodName-yyyy-mm-dd-hr-min-sec.png

        // 1. Get method name
        String methodName = result.getName();
        // 2. Get taken time
        Calendar calendar = new GregorianCalendar();
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH + 1);
        int d = calendar.get(Calendar.DATE);
        int hr = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        String fileName = methodName + "-" + y + "-" + m + "-" + d + "-" + hr + "-" + min + "-" + sec + ".png";
        // 3. Take screenshot
        File screenshotBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try{
            // 4. Save
            String fileLocation = System.getProperty("user.dir") + "/screenshot" + fileName;
            FileUtil.copyFile(screenshotBase64Data, new File(fileLocation));

            //5. Attach into report
            Path content = Paths.get(fileLocation);
            try(InputStream inputStream = Files.newInputStream(content)){
                Allure.addAttachment(methodName, inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
