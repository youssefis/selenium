package com.test.blaze.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class TestBaseBlaze {
    public WebDriver driver;
    @BeforeSuite
    public void clearTheCaches(){
    driver=DriverHelper.getDrive();
    driver.manage().deleteAllCookies();
    }


    @BeforeMethod
    public void setup() {

        driver= DriverHelper.getDrive();
        driver.get("https://demoblaze.com/#");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if (!iTestResult.isSuccess()){
            Thread.sleep(3000);
            BrowserUtils.getScreenShot(driver,"blazepicture");
        }
        driver.quit();
    }

}
