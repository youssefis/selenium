package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void alertAcceptAndGetText() throws InterruptedException {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    WebElement alertButton=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
    alertButton.click();
    Alert alert=driver.switchTo().alert();
    String actualAlertText=alert.getText(); //get text from alert POP-UP //this is POP-UP i can not inspect
    String expectAlertText="I am a JS Alert"; // we can not use getText from browserUtils with Alerts
//    Assert.assertEquals(actualAlertText,expectAlertText);

    SoftAssert softAssert=new SoftAssert();
    softAssert.assertEquals(actualAlertText,expectAlertText,"There is a comparison problem");
    Thread.sleep(500);
    alert.accept(); //click ok button
    WebElement message=driver.findElement(By.cssSelector("#result"));
    String actualMessage= BrowserUtils.getText(message);
    String expectedMessage= "You successfully clicked an alert";
    Assert.assertEquals(actualMessage,expectedMessage);
    softAssert.assertAll();
}

    @Test
    void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(3000);
        WebElement alertButton=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        alertButton.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();

        WebElement message=driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage= "You clicked: Cancel";
//        Assert.assertEquals(actualMessage,expectedMessage);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualMessage,expectedMessage);
        softAssert.assertAll();
        Thread.sleep(3000);

    }
    @Test
    void AlertSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        WebElement alertButton=driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]"));
        alertButton.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("I will follow my plan today");
        alert.accept();
        WebElement message=driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage= "You entered: I will follow my plan today";
        Assert.assertEquals(actualMessage,expectedMessage);




    }



}
