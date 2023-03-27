package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class SauceProductsPage {

    public SauceProductsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".inventory_item_name")
    List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement productDescription;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement productPrice ;

    @FindBy(xpath = "//button[.='Add to cart']")
    WebElement addToCardButton;

    @FindBy(css=".shopping_cart_link")
    WebElement cartPageButton;

    @FindBy(css = "#checkout")
    WebElement checkoutButton;

    public void chooseProduct(String productName, String expectedDescription, String expectedPrice) throws InterruptedException {

        for(WebElement product:allProducts){
            if (BrowserUtils.getText(product).contains(productName)) {
                product.click();
                break;
            }
        }
        Thread.sleep(1000);
        Assert.assertTrue(BrowserUtils.getText(productDescription).contains(expectedDescription));
        Assert.assertEquals(BrowserUtils.getText(productPrice),expectedPrice);
        addToCardButton.click();
        Thread.sleep(1000);
        cartPageButton.click();
        Thread.sleep(1000);
        checkoutButton.click();

    }






}
