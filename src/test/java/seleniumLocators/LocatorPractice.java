package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {

        //1-Automation setup
        System.setProperty("webDriver.chrome.driver","chromeDriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        //2-Automation process
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Youssef");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("El houssaini");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("yusuf1997293@gmail.com");
        driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("773-704-0000");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("YSfK000?");
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("YSfK000?");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Created!')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)?"Passed":"Failed");




    }
}






















