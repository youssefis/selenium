package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton=driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\User\\Desktop\\image.png");
        //driver.findElement(By.cssSelector("#file-submit")).click();
        driver.findElement(By.cssSelector("#file-submit")).submit();
        WebElement message=driver.findElement(By.xpath("//h3"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="File Uploaded!";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    void practice2 () throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload");
        WebElement chooseFileButton=driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFileButton.sendKeys("C:\\Users\\User\\Desktop\\image.png");
        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.xpath("//button[@id='submitbutton']")).click();
        Thread.sleep(2000);
        WebElement message=driver.findElement(By.xpath("//h3"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualMessage,expectedMessage);





    }
}
