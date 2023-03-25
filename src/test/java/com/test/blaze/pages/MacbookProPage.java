package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacbookProPage {
    public MacbookProPage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//h2")
    WebElement macbookPageHeader;
    @FindBy(xpath = "//h3")
    WebElement macbookProPrice;

    @FindBy(xpath = "//strong//following-sibling::p")
    WebElement macbookProDescription;

    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;

    public void macbookPageProductInfoValidation(String laptopHeader,String laptopPrice,String laptopDescription){
        Assert.assertEquals(BrowserUtils.getText(macbookPageHeader),laptopHeader);
        Assert.assertEquals(BrowserUtils.getText(macbookProPrice),laptopPrice);
        Assert.assertEquals(BrowserUtils.getText(macbookProDescription),laptopDescription);
    }

    public void clickAddToCardButton(WebDriver driver,String message) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),message);
        alert.accept();
    }


}
