package MentoringWithAhmet.bank.tests;

import MentoringWithAhmet.bank.pages.Account;
import MentoringWithAhmet.bank.pages.CustomerSelect;
import MentoringWithAhmet.bank.pages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

public class BankTestBase {

        /*
    TASK: (might be homework it depends on your performance)

    1-Click Customer Login
    2-Find Harry Potter from the List
    3-Click Login
    4-Validate the "Welcome Your Harry Potter" from header
    5-Click Deposit and put 500
    6-Validate "Deposit Successful"
    7-Click Withdraw and put 300
    8-Validate "Transaction successful"
    9-Get the balance from the Customer Page(200)
    10-Click Transaction
    11-get the 500 and 300 from the table and subtract them
    12-Validate balance from customer page amount(200) equals to transaction amount(500-300).
    12-Quit the driver
    */

    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverHelper.getDrive();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test
    public void testName() {
    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.getScreenShot(driver,"Bank");
        driver.quit();
    }


}
