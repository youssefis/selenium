package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement copyRight=driver.findElement(By.xpath("//div[contains(text(),'Copyright © ')]"));
        BrowserUtils.scrollWithJs(driver,copyRight);
        String actualCopyRight=BrowserUtils.getText(copyRight);
        String expectedCopyRight="Copyright © 2023";
        Assert.assertEquals(actualCopyRight,expectedCopyRight);
        WebElement applyNow=driver.findElement(By.xpath("//span[contains(text(),'Apply Now')]"));
        BrowserUtils.scrollWithJs(driver,applyNow);
        BrowserUtils.clickWithJs(driver,applyNow);
        List<WebElement> heading3=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedHeading3= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
        for (int i=0;i<heading3.size();i++){
            Assert.assertEquals(BrowserUtils.getText(heading3.get(i)),expectedHeading3.get(i));
        }



    }

}
