package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeMainPage {

    public BlazeMainPage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//a[.='Laptops']")
    WebElement lapTopsButton;

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    public void lapTopsButtonClick(){
        lapTopsButton.click();
    }
    public void cartButtonClick(){
        cartButton.click();
    }

}
