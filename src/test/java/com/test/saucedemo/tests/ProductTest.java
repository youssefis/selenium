package com.test.saucedemo.tests;

import com.test.saucedemo.pages.SauceLoginPage;
import com.test.saucedemo.pages.SauceProductsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProductTest extends SauceTestBase{

    @Test(dataProvider = "productInfo",dataProviderClass = AllData.class)
    public void validateAllProductLinksAreWorking(String productName, String expectedDescription,String expectedPrice) throws InterruptedException {
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.positiveLogin(ConfigReader.readProperty("QA_username")
                ,ConfigReader.readProperty("QA_password"));
        SauceProductsPage sauceProductsPage=new SauceProductsPage(driver);
        sauceProductsPage.chooseProduct(productName,expectedDescription,expectedPrice);
    }

}
