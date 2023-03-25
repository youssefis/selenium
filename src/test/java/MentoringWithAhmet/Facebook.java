package MentoringWithAhmet;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Facebook {
    @Test
    public void creatingFacebookAccount(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");
        driver.findElement(By.xpath("//a[.='Create new account']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("yusuf");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("husaini");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("f937e0bdaa@boxmail.lol");
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("f937e0bdaa@boxmail.lol");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("937e0bdaFA");
        driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("27");
        driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("Oct");
        driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("1990");
        driver.findElement(By.xpath("//label[.='Male']")).click();
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();



    }



}
