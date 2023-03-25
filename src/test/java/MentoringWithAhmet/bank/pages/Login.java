package MentoringWithAhmet.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    public Login(WebDriver driver){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLoginButton;

    public void loginClick(){
        customerLoginButton.click();
    }

}
