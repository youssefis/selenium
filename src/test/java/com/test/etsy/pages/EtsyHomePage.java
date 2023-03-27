package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class EtsyHomePage {
    public EtsyHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='search_query']")
    WebElement searchBar;

    @FindBy(xpath = "//a//div//h3")
    List<WebElement> listOfAllProducts;

    public void searchFunctionality(String searchedPhone, String text1, String text2, String text3) {

        searchBar.sendKeys(searchedPhone, Keys.ENTER);

        for (int i = 3; i < listOfAllProducts.size(); i++) {
            String word = BrowserUtils.getText(listOfAllProducts.get(i)).toLowerCase();
            Assert.assertTrue(  word.contains(text1) ||
                                        word.contains(text2) ||
                                        word.contains(text3));

        }

    }


}
