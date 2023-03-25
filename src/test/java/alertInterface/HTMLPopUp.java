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

public class HTMLPopUp {

    @Test
    void HTMLPopUpPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");
        driver.findElement(By.xpath("//button[contains(@onClick,'something went wrong')]")).click();
        Alert alert=driver.switchTo().alert();
        String actualMessage1=alert.getText();
        String expectedMessage="Oops, something went wrong!";
        Assert.assertEquals(actualMessage1,expectedMessage);
        alert.accept();

        driver.findElement(By.xpath("//button[contains(@onClick,'Something went wrong')]")).click();
        Thread.sleep(3000);
        WebElement message2=driver.findElement(By.xpath("//div[@class='swal-modal']"));
        String actualMessage2= BrowserUtils.getText(message2);
        String expectedMessage2="Oops\n" +
                "Something went wrong!\n" +
                "OK";
        Assert.assertEquals(actualMessage2,expectedMessage2);
        driver.findElement(By.xpath("//button[.='OK']")).click();

    }


}
