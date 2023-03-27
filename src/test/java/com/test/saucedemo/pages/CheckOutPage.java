package com.test.saucedemo.pages;

import com.test.saucedemo.tests.AllData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class CheckOutPage {

    public CheckOutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#first-name")
    WebElement firstName;

    @FindBy(css = "#last-name")
    WebElement lastName;

    @FindBy(css = "#postal-code")
    WebElement postalCode;

    @FindBy(css = "#continue")
    WebElement continueButton;

    @FindBy(css = "#finish")
    WebElement finishButton;

    @FindBy(xpath = "//h2")
    WebElement thankMessage;

    public void fillCheckOutInfo(String firstName,String lastName,String postCode,String expectedThankMessage){

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postCode);
        continueButton.click();
        finishButton.click();
        Assert.assertEquals(BrowserUtils.getText(thankMessage),expectedThankMessage);



    }
}
