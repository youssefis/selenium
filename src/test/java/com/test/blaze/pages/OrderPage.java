package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {

    public OrderPage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;
    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you ')]")
    WebElement thankMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;


    public void placeOrderButtonClick(){
        placeOrderButton.click();
    }

    public void validateOrderFunctionality(String name, String country, String city, String card, String month, String year, String expectedMessage ) throws InterruptedException {

        this.name.sendKeys(name);
        Thread.sleep(500);
        this.country.sendKeys(country);
        Thread.sleep(500);
        this.city.sendKeys(city);
        Thread.sleep(500);
        this.card.sendKeys(card);
        Thread.sleep(500);
        this.month.sendKeys(month);
        Thread.sleep(500);
        this.year.sendKeys(year);
        Thread.sleep(500);
        purchaseButton.click();
        Thread.sleep(500);
        Assert.assertEquals(BrowserUtils.getText(thankMessage),expectedMessage);
        okButton.click();
        Thread.sleep(500);



    }


}
