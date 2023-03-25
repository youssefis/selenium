package MentoringWithAhmet.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CustomerSelect {

    public CustomerSelect(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement listOfUsers;

    @FindBy(xpath = "//button[.='Login']")
    WebElement loginButton;



    public void customerListSelect(String name) {
        BrowserUtils.selectBy(listOfUsers, name, "text");
        loginButton.click();
    }







}
