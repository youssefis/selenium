package com.test.blaze.tests;

import com.test.blaze.pages.BlazeMainPage;
import com.test.blaze.pages.LaptopsPage;
import com.test.blaze.pages.MacbookProPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacbookProTest extends TestBaseBlaze {
    @Parameters({"laptopBrand","laptopPrice","message","description"})
    @Test
    public void macbookProPageFunctionality(String laptopBrand,String laptopPrice,String message,String description) throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        blazeMainPage.lapTopsButtonClick();
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        Thread.sleep(3000);
        laptopsPage.macbookProClick(driver,laptopBrand);
        MacbookProPage macbookProPage = new MacbookProPage(driver);
        macbookProPage.macbookPageProductInfoValidation(laptopBrand,laptopPrice,description);
        Thread.sleep(2000);
        macbookProPage.clickAddToCardButton(driver,message);
        //"$1100 *includes tax"
    }

}
