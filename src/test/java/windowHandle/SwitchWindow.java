package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void switchPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        String mainPageID=driver.getWindowHandle();
        System.out.println(mainPageID); //CDwindow-6026007E931ED5B42333632C03E7D4E7
        Set<String> allPagesId=driver.getWindowHandles();
        System.out.println(allPagesId);

        for (String id:allPagesId){
            //this is used for only 2 tabs/windows
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

    }

    @Test
    public void practice1() throws InterruptedException {
        /*
        TASK:
          1-Navigate to the website "https://www.hyrtutorials.com/p/window-handles-practice.html"
          2-Click Open New Tab under Button2
          3-Get the title of the newTab and validate
          4-Get the header of the newTab and validate "AlertsDemo"
          5-Click click me button
          6-Quit the tabs
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement newTabButton=driver.findElement(By.cssSelector("#newTabBtn"));
        newTabButton.click();
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesIds=driver.getWindowHandles();

        for (String id:allPagesIds){

            if (!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }
        String actualTitleOfTheNewTab=driver.getTitle();
        String expectedTitleOfNewTab="AlertsDemo - H Y R Tutorials";
        System.out.println(actualTitleOfTheNewTab);
        Assert.assertEquals(actualTitleOfTheNewTab,expectedTitleOfNewTab);

        WebElement NewTanHeader=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualNewTabHeader=BrowserUtils.getText(NewTanHeader);
        String expectedNewTabHeader="AlertsDemo";

        WebElement clickMeBox=driver.findElement(By.cssSelector("#alertBox"));
        clickMeBox.click();
        Thread.sleep(3000);
        driver.quit();




    }

}
