package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//form//div//input")
    List<WebElement> customerInformationBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement customerInfoSubmitButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;

    @FindBy(xpath = "//form//select")
    List<WebElement> openAccountInfoBox;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement listOfCustomersButton;

    @FindBy(xpath = "//tbody//tr//td[4]")
    List<WebElement> listOfCustomersAccountNumber;

    @FindBy(xpath = "//tbody//tr//td[5]//button")
    List<WebElement> getListOfCustomersDeleteButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBar;

    @FindBy(xpath = "//tbody//tr//td")
    List<WebElement> actualFirstNameLastNamePostCode;

    public void addCustomerButtonClick() {
        addCustomerButton.click();
    }

    public void customerInformationFiller(String firstName, String lastName, String postCode) {
        List<String> customerInfo = Arrays.asList(firstName, lastName, postCode);
        for (int i = 0; i < customerInformationBox.size(); i++) {
            customerInformationBox.get(i).sendKeys(customerInfo.get(i));
        }
    }

    public void customerInfoSubmitButtonClick() {
        customerInfoSubmitButton.click();
    }

    public String customerSignUpConfirmationMessageAlertText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        return alert.getText();
    }

    public void customerSignUpConfirmationMessageAlertAccept(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void openAccountButtonClick() {
        openAccountButton.click();
    }

    public void processButtonClick() {
        processButton.click();
    }

    public void openAccountInfoBoxFiller(String customerName, String currency) {
        BrowserUtils.selectBy(openAccountInfoBox.get(0), customerName, "text");
        BrowserUtils.selectBy(openAccountInfoBox.get(1), currency, "text");
    }

    public void listOfCustomersButtonClick() {
        listOfCustomersButton.click();
    }

    public void deleteYourAccount(String accountNumber) {
        for (int i = 0; i < listOfCustomersAccountNumber.size(); i++) {
            if (BrowserUtils.getText(listOfCustomersAccountNumber.get(i)).trim().equals(accountNumber)) {
                getListOfCustomersDeleteButton.get(i).click();
            }
        }
    }

    public WebElement lastElementOfListOfCustomersAccountNumber() {
        System.out.println(BrowserUtils.getText(listOfCustomersAccountNumber.get(listOfCustomersAccountNumber.size() - 1)));
        return listOfCustomersAccountNumber.get(listOfCustomersAccountNumber.size() - 1);
    }

    public void setSearchBarFunctionality(String accountNumber,String firstName, String lastName, String postCode){
        List expectedFirstNameLastNamePostCode=Arrays.asList(firstName,lastName,postCode);
        searchBar.sendKeys(accountNumber);
        for (int i = 0; i< expectedFirstNameLastNamePostCode.size(); i++){
            Assert.assertEquals(BrowserUtils.getText(actualFirstNameLastNamePostCode.get(i)),expectedFirstNameLastNamePostCode.get(i));
        }
    }


}
