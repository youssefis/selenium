package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GetAttribute {

    public static void main(String[] args) {

        System.setProperty("webDriver.Chrome.driver", "chromeDriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]")).click();
        WebElement demoUserName=driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        System.out.println(demoUserName.getText().trim()); // was expecting John Doe //this will not work
        System.out.println(demoUserName.getAttribute("value")); //this will work
        System.out.println(demoUserName.getAttribute("placeholder")); //

    }

}
