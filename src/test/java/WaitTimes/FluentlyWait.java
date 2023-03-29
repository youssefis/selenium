package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class FluentWait {
    WebDriver driver;
    @Test
    public void fluentWaitTest(){
        driver= DriverHelper.getDrive();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();
    }
}
