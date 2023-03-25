package com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver) {PageFactory.initElements(driver,this);}
    @FindBy (xpath = "//button[.='Bank Manager Login']")
    WebElement bankManagerLoginButton;

    public void clickBankManagerLoginButton(){
        bankManagerLoginButton.click();
    }

}
