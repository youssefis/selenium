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
import org.testng.annotations.Test;

import java.time.Duration;

public class MacbookProTest extends TestBaseBlaze {

    @Test
    public void macbookProPageFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
        blazeMainPage.lapTopsButtonClick();
        LaptopsPage laptopsPage = new LaptopsPage(driver);
        Thread.sleep(3000);
        laptopsPage.macbookProClick(driver,"MacBook Pro");
        MacbookProPage macbookProPage = new MacbookProPage(driver);
        macbookProPage.macbookPageProductInfoValidation("MacBook Pro","$1100 *includes tax","Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        Thread.sleep(1000);
        macbookProPage.clickAddToCardButton(driver,"Product added");

    }

}
