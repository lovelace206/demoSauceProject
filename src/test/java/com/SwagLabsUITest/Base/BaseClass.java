package com.SwagLabsUITest.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.SwagLabsUITest.Pages.P1_LoginPage;
import com.SwagLabsUITest.Pages.P2_InventoryPage;


public class BaseClass {

    public static WebDriver driver;
    public P1_LoginPage lp;
    public P2_InventoryPage pi;
    public void slow(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("=== Test Suite Started ===");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        System.out.println("Browser launched");
        lp = new P1_LoginPage(driver);
      //  pi=new P2_InventoryPage(driver);
    }
    @BeforeClass
    public void setupInventory() {


        pi = new P2_InventoryPage(driver);
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("=== Test Suite Finished ===");
        driver.close();
     System.out.println("Browser closed");
    }

    @BeforeClass
    public void setup() {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");
//        System.out.println("Browser launched");
//        lp = new P1_LoginPage(driver);
//        pi=new P2_InventoryPage(driver);
    }

    @BeforeMethod
    public void openApp() {
//        driver.get("https://www.saucedemo.com/");
//        lp = new P1_LoginPage(driver);
//        pi=new P2_InventoryPage(driver);
        System.out.println("Application opened");
    }

    @AfterMethod
    public void captureOnFail(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            new File("C:\\Screenshots").mkdirs();

            File dest = new File(
                    "C:\\Screenshots\\" + result.getName() + ".png");

            FileHandler.copy(src, dest);

            System.out.println("Screenshot saved for failed test");
        }

        System.out.println("Test finished: " + result.getName());
    }

//    @AfterSuite
//    public void tearDown() {
//        driver.quit();
//        System.out.println("Browser closed");
//    }
}
