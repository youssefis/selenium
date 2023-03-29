package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {

    WebDriver driver;
    @Test
    public void validateTheText(){
        driver= DriverHelper.getDrive();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.xpath("//a[contains(text(),'Example 1')]")).click();
        driver.findElement(By.xpath("//button[.='Start']")).click();
        WebElement text=driver.findElement(By.xpath("//div[@id='finish']//h4"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text),"Hello World!");
    }

    @Test
    public void validateText2(){
        driver=DriverHelper.getDrive();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        WebElement message=driver.findElement(By.xpath("//form//p"));
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        message=wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");
    }
}
