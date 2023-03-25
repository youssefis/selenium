package actionClass;

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
import java.util.*;

public class HoverOver {
    @Test
    public void validateNamesFromPictures() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        List<WebElement> names=driver.findElements(By.tagName("h5"));
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames=new ArrayList<>();
        List<String> expectedNames= Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions=new Actions(driver);


        for (int i=0;i<names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(allImages.get(i)).perform(); // hover overing the pictures
            actualNames.add(BrowserUtils.getText(names.get(i))); // storing the names inside the list for validation
        }
        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames,expectedNames);
    }
    @Test
    public void practiceMoveToElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        List<WebElement> allImages=driver.findElements(By.xpath("//div[@role='listitem']//img"));
        List<WebElement> allNames=driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String,String> namesAndPrices=new LinkedHashMap<>();
        Actions actions=new Actions(driver);
        actions.scrollByAmount(400,400);
        for (int i=0;i<allImages.size();i++){
            actions.moveToElement(allImages.get(i)).perform();
            namesAndPrices.put(BrowserUtils.getText(allNames.get(i)),BrowserUtils.getText(allPrices.get(i)));
        }
        System.out.println(namesAndPrices);






    }
}
