package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class BankManagerFunctionality {
                /*
        1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        2-Click Bank Manager Login
        3-Click Add Customer
        4-Fill the blanks and click add customer button
        5-Get the text from pop-up and VALIDATE and click OK
        6-Click Open Account
        7-Choose your name from the list
        8-Choose any currency you want from list
        9-Get the text from pop-up and VALIDATE account successfully created contains and click OK
        10-Click Customers Button
        11-Search your name on the searchBar
        12-Validate your firstname,lastName,PostCode and click delete
        13-driver.quit
        14-Proud of yourself
         */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test
    public void driverManagerTest() throws InterruptedException {
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankLoginPage.clickBankManagerLoginButton();
        bankManagerPage.addCustomerButtonClick();
        bankManagerPage.customerInformationFiller("YUSUF","HOSAINI","60631");
        Thread.sleep(500);
        bankManagerPage.customerInfoSubmitButtonClick();
        Assert.assertTrue(bankManagerPage.customerSignUpConfirmationMessageAlertText(driver).contains("Customer added successfully"));
        bankManagerPage.customerSignUpConfirmationMessageAlertAccept(driver);
        bankManagerPage.openAccountButtonClick();
        bankManagerPage.openAccountInfoBoxFiller("YUSUF HOSAINI","Dollar");
        bankManagerPage.processButtonClick();
        Assert.assertTrue(bankManagerPage.customerSignUpConfirmationMessageAlertText(driver).contains("Account created successfully"));
        bankManagerPage.customerSignUpConfirmationMessageAlertAccept(driver);
        bankManagerPage.listOfCustomersButtonClick();
        BrowserUtils.scrollWithJs(driver,bankManagerPage.lastElementOfListOfCustomersAccountNumber());

        Thread.sleep(1000);
        bankManagerPage.setSearchBarFunctionality("1016","YUSUF","HOSAINI","60631");
        Thread.sleep(1000);
        bankManagerPage.deleteYourAccount("1016");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
