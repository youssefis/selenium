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

public class NestedFrame {

    @Test
    void nestedFrame(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftFrame=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        String actualLeftFrame= BrowserUtils.getText(leftFrame);
        String expectedLeftFrame="LEFT";
        Assert.assertEquals(actualLeftFrame,expectedLeftFrame);

        //Middle and right
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame=driver.findElement(By.cssSelector("#content"));
        String actualMiddleFrame=BrowserUtils.getText(middleFrame);
        String expectedMiddleFrame="MIDDLE";
        Assert.assertEquals(actualMiddleFrame,expectedMiddleFrame);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrame=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        String actualRightFrame=BrowserUtils.getText(rightFrame);
        String expectedRightFrame="RIGHT";
        Assert.assertEquals(actualRightFrame,expectedRightFrame);
        driver.switchTo().defaultContent(); // switch to the main html
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actualBottomFrame=BrowserUtils.getText(bottomFrame);
        String expectedBottomFrame="BOTTOM";
        Assert.assertEquals(actualBottomFrame,expectedBottomFrame);









    }

}
