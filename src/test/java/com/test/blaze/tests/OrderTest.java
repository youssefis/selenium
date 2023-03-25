package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrderTest extends TestBaseBlaze{

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.lapTopsButtonClick();
        OrderPage orderPage=new OrderPage(driver);
        Thread.sleep(2000);
        LaptopsPage laptopsPage=new LaptopsPage(driver);
        laptopsPage.macbookProClick(driver,"MacBook Pro");
        MacbookProPage macbookProPage=new MacbookProPage(driver);
        macbookProPage.clickAddToCardButton(driver,"Product added");
        blazeMainPage.cartButtonClick();
        CartPage cartPage=new CartPage(driver);
        cartPage.validateProductInformation("MacBook Pro","1100");
        orderPage.placeOrderButtonClick();
        Thread.sleep(2000);
        orderPage.validateOrderFunctionality("yusuf","morocco","marrakech","1234","10","2023","Thank you for your purchase!");
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://demoblaze.com/index.html");

    }

}
