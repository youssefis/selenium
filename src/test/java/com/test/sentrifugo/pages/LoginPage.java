package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    // store all webElements and methods inside a specific pages (loginPage)

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='input-username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div//h5//following-sibling::button")
    WebElement closeButton;

    @FindBy(xpath = "//div[contains(text(),'Username and/or Password.')]")
    WebElement errorMessage;

    public void login(String username,String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);

        loginButton.click();
        closeButton.click();


    }
    public void negativeLogin(String username,String password){

        this.username.sendKeys(username);
        this.password.sendKeys(password);

        loginButton.click();


    }

    public String validateErrorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
    public String validateColorOfErrorMessage(){
        return errorMessage.getCssValue("color").trim(); //rgba color
    }


}
