package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentlyWait {
    WebDriver driver;
    @Test
    public void fluentWaitTest(){
        driver= DriverHelper.getDrive();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        Wait<WebDriver> fluentWait=new FluentWait<>(driver) //polymorphism
                .pollingEvery(Duration.ofSeconds(3))
                .withMessage("Text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
        WebElement message=fluentWait.until(mydriver->driver.findElement(By.xpath("//p[@id='message']")));
        System.out.println(BrowserUtils.getText(message));
    }
}
