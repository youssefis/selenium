package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CssLocator {

    public static void main(String[] args) {
        System.setProperty("webDriver.chrome.driver","chromeDriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.etsy.com/");
//        driver.findElement(By.cssSelector("#global-enhancements-search-query")).sendKeys("Watch", Keys.ENTER);
//        System.out.println(driver.getTitle().trim());
        driver.findElement(By.cssSelector(".wt-input")).sendKeys("Watch",Keys.ENTER);
        System.out.println(driver.getTitle().trim());




    }

}
