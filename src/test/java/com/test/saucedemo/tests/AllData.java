package com.test.saucedemo.tests;

import org.testng.annotations.DataProvider;

public class AllData {

    @DataProvider(name="negativeLogin")
    public Object[][] getUserInfo(){
        return new Object[][]{
                {"standard_user","","Epic sadface: Password is required"},
                {"","","Epic sadface: Username is required"},
                {"dqdd","eedsa","Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @DataProvider(name = "productInfo")
    public Object[][] getProductInfo(){
        return new Object[][]{
                {"Sauce Labs Backpack", "Sly Pack", "$29.99"},
                {"Sauce Labs Bike Light", "lighting modes", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "ringspun combed cotton", "$15.99"},
                {"Sauce Labs Fleece Jacket", "fleece jacket", "$49.99"},
                {"Sauce Labs Onesie", "junior automation engineer", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "Super-soft and comfy", "$15.99"},
        };
    }

    @DataProvider(name = "AllInfo")
    public Object[][] getCheckOutInfo(){

        return new Object[][]{
                {"Sauce Labs Backpack", "Sly Pack", "$29.99","yusuf","hosin","6060","Thank you for your order!"},
                {"Sauce Labs Bike Light", "lighting modes", "$9.99","yusuf","hosin","6060","Thank you for your order!"},
                {"Sauce Labs Bolt T-Shirt", "ringspun combed cotton", "$15.99","yusuf","hosin","6060","Thank you for your order!"},
                {"Sauce Labs Fleece Jacket", "fleece jacket", "$49.99","yusuf","hosin","6060","Thank you for your order!"},
                {"Sauce Labs Onesie", "junior automation engineer", "$7.99","yusuf","hosin","6060","Thank you for your order!"},
                {"Test.allTheThings() T-Shirt (Red)", "Super-soft and comfy", "$15.99","yusuf","hosin","6060","Thank you for your order!"}

        };

    }


}
