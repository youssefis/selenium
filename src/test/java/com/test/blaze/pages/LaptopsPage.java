package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopsPage {

    public LaptopsPage(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//h4//a")
    List<WebElement> allLaptops;

    public void macbookProClick(WebDriver driver,String brand){

        for (WebElement laptop:allLaptops){

            if (BrowserUtils.getText(laptop).equals(brand)){
                Actions actions=new Actions(driver);
                actions.scrollToElement(laptop);
                laptop.click();
                break;

            }

        }

    }
}
