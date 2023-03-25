package seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class YoutubeRealInterviewQuestion {

    /*
      1-Navigate to the website youtube
      2-Search for justin bieber
      3-Find the all song names and store in the list Justin Bieber - Hold On (Live from Paris)
      4-Use for and if conditions to find the song
      5-Click the song
      6-Enjoy your music
      7-Ready to be level 2
    */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.chrome.driver","chromeDriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        WebElement searchBar=driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("othman farouk english");
        driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
        Thread.sleep(3000);
        List<WebElement> allTitles=driver.findElements(By.xpath("//a[@id='video-title']"));
        for (WebElement title:allTitles){
            title.sendKeys(Keys.ARROW_DOWN);
            //Thread.sleep(250);
            if(title.getAttribute("title").trim().contains("SALAFI")){
                title.click();
                break;
            }

        }





    }



}
