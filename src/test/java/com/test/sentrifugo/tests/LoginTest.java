package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @Test
    public void validateSuccessfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        LoginPage loginPage=new LoginPage(driver); //for pageFactory to initialize your element
        loginPage.login("demo","demo");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(),"Dashboard");
    }

    @Test
    public void validateNegativeLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.negativeLogin("demoo","demooo");
        Assert.assertEquals(loginPage.validateErrorMessage(),"No match for Username and/or Password.");
        Assert.assertEquals(loginPage.validateColorOfErrorMessage(),"rgba(136, 48, 37, 1)");
    }

}
