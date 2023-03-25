package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {
    @Test
    void popUpPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        driver.findElement(By.cssSelector("#alertBox")).click();
        Alert alert=driver.switchTo().alert();
        String actualAlertText=alert.getText();
        String expectAlertText="I am an alert box!";
        Assert.assertEquals(actualAlertText,expectAlertText);
        alert.accept();
        WebElement message=driver.findElement(By.cssSelector("#output"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You selected alert popup";
        Assert.assertEquals(actualMessage,expectedMessage);

        driver.findElement(By.cssSelector("#confirmBox")).click();
        driver.switchTo().alert();
        alert.accept();
        WebElement message2=driver.findElement(By.cssSelector("#output"));
        String actualMessage2= BrowserUtils.getText(message2);
        String expectedMessage2="You pressed OK in confirmation popup";
        Assert.assertEquals(actualMessage2,expectedMessage2);

        driver.findElement(By.cssSelector("#promptBox")).click();
        driver.switchTo().alert();
        alert.sendKeys("I will start making plans for my life");
        alert.accept();
        WebElement message3=driver.findElement(By.cssSelector("#output"));
        String actualMessage3= BrowserUtils.getText(message3);
        String expectedMessage3="You entered text I will start making plans for my life in propmt popup";
        Assert.assertEquals(actualMessage3,expectedMessage3);









    }

}
