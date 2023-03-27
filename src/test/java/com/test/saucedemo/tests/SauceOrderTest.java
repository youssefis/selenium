package com.test.saucedemo.tests;

import com.test.saucedemo.pages.CheckOutPage;
import com.test.saucedemo.pages.SauceLoginPage;
import com.test.saucedemo.pages.SauceProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigReader;

public class SauceOrderTest extends SauceTestBase {

    @Test(dataProvider = "AllInfo", dataProviderClass = AllData.class)
    public void validateOrderFunctionality(String productName, String expectedDescription, String expectedPrice,
                                           String firstName, String lastName, String postCode, String expectedThankMessage) throws InterruptedException {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.positiveLogin(ConfigReader.readProperty("QA_username")
                , ConfigReader.readProperty("QA_password"));
        SauceProductsPage sauceProductsPage = new SauceProductsPage(driver);
        sauceProductsPage.chooseProduct(productName, expectedDescription, expectedPrice);
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.fillCheckOutInfo(firstName, lastName, postCode, expectedThankMessage);
    }


}
