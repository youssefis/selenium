package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class JavaScriptMethods {
    // we use javaScript methods when Selenium methods are not working
    //as expected.specifically, click,getTitle,
    //Note: we love using scrollIntoView Method from JavaScript in
    //professional environment
    @Test
    public void getTitle(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle()+" This is regular driver method fro title");

        //if this one does not work then we use JS method
        JavascriptExecutor js= (JavascriptExecutor) driver; //now the driver is acting as a JS executor
        String title=js.executeScript("return document.title").toString();
        System.out.println(title+ " This is JS method for title");
    }
    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");
        WebElement yesButton=driver.findElement(By.id("yesRadio"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",yesButton);
        WebElement message=driver.findElement(By.xpath("//p[@class='mt-3']"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You have selected Yes";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement impressiveButton=driver.findElement(By.cssSelector("#impressiveRadio"));
        Thread.sleep(500);
        js.executeScript("arguments[0].click()",impressiveButton);
        Thread.sleep(500);
        String actualImpressiveMessage=BrowserUtils.getText(message);
        String expectedImpressiveMessage="You have selected Impressive";
        Assert.assertEquals(actualImpressiveMessage,expectedImpressiveMessage);

    }

    @Test
    //**** this one is all about scrolling the page based on the location of the element
    public void scrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement findCourse=driver.findElement(By.xpath("//span[.='Find out which course is for you']//.."));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",findCourse);//***
        Thread.sleep(3000);
        js.executeScript("arguments[0].click",findCourse);//**
        System.out.println(js.executeScript("return document.title"));//*

    }
    @Test
    public void shortCutJsMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement findCourse=driver.findElement(By.xpath("//span[.='Find out which course is for you']//.."));
        Thread.sleep(3000);
        BrowserUtils.scrollWithJs(driver,findCourse);
        BrowserUtils.clickWithJs(driver,findCourse);
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesId=driver.getWindowHandles();
        for (String id:allPagesId){

            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }

        }
        System.out.println(BrowserUtils.getTitleWithJs(driver));


    }




}
