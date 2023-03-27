package com.test.etsy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.DriverHelper;

public class EtsySearchBarFunctionality {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDrive();
        driver.get("https://www.etsy.com/?ref=lgo");
    }


}
