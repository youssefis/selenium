package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class switchMultipleWindows {

    @Test
    public void multipleWindowsPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");
        BrowserUtils.switchByTitle(driver, "Contact us");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver, "Home");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver, "Courses");
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void task2() throws InterruptedException {

                /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful"
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and click  the "Click Me" button under prompt box
        7-quit all the pages.
        8-Proud of yourself
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement multipleTabsButton=driver.findElement(By.cssSelector("#newTabsBtn"));
        Actions actions=new Actions(driver);
        BrowserUtils.scrollWithJs(driver,multipleTabsButton);
        Thread.sleep(2000);
        BrowserUtils.clickWithJs(driver,multipleTabsButton);
        BrowserUtils.switchByTitle(driver,"Basic Controls - H Y R Tutorials");
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Yusuf");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Hosaini");
        driver.findElement(By.cssSelector("#englishchbx")).click();
        WebElement emailBox=driver.findElement(By.cssSelector("#email"));
        BrowserUtils.scrollWithJs(driver,emailBox);
        emailBox.sendKeys("yusuf@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("abcQWE989");
        driver.findElement(By.cssSelector("#registerbtn")).click();
        WebElement confirmationMessage=driver.findElement(By.cssSelector("#msg"));
        String actualMessage=confirmationMessage.getText();
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);
        BrowserUtils.switchByTitle(driver,"Window Handles Practice");
        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=header.getText();
        String expectedHeader="Window Handles Practice";
        Assert.assertEquals(actualHeader,expectedHeader);
        BrowserUtils.switchByTitle(driver,"AlertsDemo - H Y R Tutorials");
        driver.findElement(By.cssSelector("#promptBox")).click();
        Thread.sleep(2000);
        driver.quit();










    }



}
