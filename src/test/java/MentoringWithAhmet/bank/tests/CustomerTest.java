package MentoringWithAhmet.bank.tests;

import MentoringWithAhmet.bank.pages.Account;
import MentoringWithAhmet.bank.pages.CustomerSelect;
import MentoringWithAhmet.bank.pages.Login;
import org.testng.annotations.Test;

public class CustomerTest extends BankTestBase {

    @Test
    public void validateCustomerLoginFunctionality() throws InterruptedException {

        Login login=new Login(driver);
        login.loginClick();
        CustomerSelect customerSelect=new CustomerSelect(driver);
        customerSelect.customerListSelect("Harry Potter");
        Account account=new Account(driver);
        Thread.sleep(2000);
        account.WelcomeMessageValidation("Welcome Harry Potter !!");
        Thread.sleep(2000);
        account.validateDepositFunctionality("500","Deposit Successful");
    }

}
