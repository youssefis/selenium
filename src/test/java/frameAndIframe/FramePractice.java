package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FramePractice {
    @Test
    public void iFramePractice(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement header=driver.findElement(By.xpath("//h3"));
        String ActualHeader=header.getText();
        String expectedHeader="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(ActualHeader,expectedHeader);
        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox=driver.findElement(By.cssSelector("#tinymce"));
        textBox.clear();
        textBox.sendKeys("I love Java");
        driver.switchTo().parentFrame();
        WebElement elementalSelenium=driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();
        BrowserUtils.switchByTitle(driver,"Elemental Selenium:");
        WebElement header2=driver.findElement(By.xpath("//h1"));
        String actualHeader2=header2.getText();
        String expectedHeader2="Elemental Selenium";
        Assert.assertEquals(actualHeader2,expectedHeader2);




    }
}
