package MentoringWithAhmet.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class Account {

    public Account(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement headerMessage;
    @FindBy(xpath = "//div[@class='center']//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "//input")
    WebElement depositAmountBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDepositButton;

    @FindBy(xpath = "//span[contains(text(),'Successful')]")
    WebElement depositMessageValidation;

    public void WelcomeMessageValidation(String expectedMessage){
        Assert.assertEquals(BrowserUtils.getText(headerMessage),expectedMessage);

    }

    public void validateDepositFunctionality(String amount,String expectedDepositMessage) throws InterruptedException {
        depositButton.click();
        Thread.sleep(2000);
        depositAmountBox.sendKeys(amount);
        Thread.sleep(2000);
        submitDepositButton.click();
        Assert.assertEquals(BrowserUtils.getText(depositMessageValidation),expectedDepositMessage);
    }




}
