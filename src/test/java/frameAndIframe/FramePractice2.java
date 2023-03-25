package frameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class FramePractice2 {
    /*
    1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
    2-click pavilion
    3-choose "selenium-java" from selenium button
    4-validate the header "selenium-java Tutorial - Basic to advance"
    5-Print out table of content options on console
    6-wait for second task 2
     */
    /*
    task 2:
    1-Go back to the main page
    2-click category 1
    3-validate the header "Category Archives: SeleniumTesting"
    4-Print out all the headers of the contents (it will be explained)

     */

    @Test
    void practiceFrame(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.findElement(By.linkText("Pavilion")).click();
        BrowserUtils.switchByTitle(driver,"Home - qavalidation");
        WebElement seleniumButton=driver.findElement(By.xpath("//ul[@id='primary-menu']//li//a[.='Selenium']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(seleniumButton);
        WebElement seleniumJava=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']"));
        actions.click(seleniumJava).perform();
        WebElement header=driver.findElement(By.xpath("//h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader,expectedHeader);
        List<WebElement> tableOfContent=driver.findElements(By.xpath("//ul[@class='ht_toc_list']//li"));
        for (WebElement element:tableOfContent){
            System.out.println(BrowserUtils.getText(element));
        }
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Framename1");
        driver.findElement(By.xpath("//a[.='Category1']")).click();
        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        WebElement header2=driver.findElement(By.xpath("//h1"));
        String actualHeader2=BrowserUtils.getText(header2);
        String expectedHeader2="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeader2,expectedHeader2);
        List<WebElement> allHeaders=driver.findElements(By.xpath("//h3//a"));
        for (WebElement item:allHeaders){
            System.out.println(item.getAttribute("title"));
        }
        /*
        Task 3:
        1-Go back to main Page
        2-Click Category 3
        3-Validate the header "Category Archives: SoftwareTesting"
         */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        driver.findElement(By.xpath("//a[.='Category3']")).click();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");
        WebElement header3=driver.findElement(By.xpath("//h1['Category Archives: ']"));
        String actualHeader3=BrowserUtils.getText(header3);
        String expectedHeader3="Category Archives: SoftwareTesting";
        Assert.assertEquals(actualHeader3,expectedHeader3);
        






    }

}
