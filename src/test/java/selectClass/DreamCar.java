package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
        /*
    NOTE: Please use browser utils for the select classes if it is needed.
    1-Navigate to the website
    2-Choose the "New Cars" from the New/used option
    3-Choose "Lexus" for Make part
    4-Choose "RX-350"
    5-Validate the Price is selected "No max price"-->getFirstSelectedOption
    6-Choose the distance 40 mil
    7-Put your Zip code-->Before that Clear it.60056
    8-Click Search Button
    9-Validate the header "New Lexus RX 350 for sale"
    10-Click Sort by and choose the Lowest Price
    11-Validate the all titles has Lexus RX 350
         */
    @Test
    public void validateHeadersOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
        WebElement makeModuleBox=driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(makeModuleBox,"New","text");
        WebElement makesBox=driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(makesBox,"Lexus","text");
        WebElement modelsBox=driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(modelsBox,"lexus-rx_350","value");
        WebElement maxPriceBox=driver.findElement(By.cssSelector("#make-model-max-price"));
        Select maxPrice=new Select(maxPriceBox);
        String actualMaxPrice = BrowserUtils.getText(maxPrice.getFirstSelectedOption());
        String expectedMaxPrice="No max price";
        Assert.assertEquals(actualMaxPrice,expectedMaxPrice);
        WebElement maximumDistanceBox=driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(maximumDistanceBox,"40","value");
        WebElement zipCode=driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        driver.findElement(By.xpath("//button[@data-linkname='search-new-make']")).click();
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement sortBox=driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBox,"Lowest price","text");
        Thread.sleep(2000);
        List<WebElement> AllTitles=driver.findElements(By.xpath("//h2[@class='title']"));
        int c=1;
        for (WebElement title:AllTitles){
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350"));
        }
        List <WebElement> allPrices=driver.findElements(By.cssSelector(".primary-price"));
        List <Integer> actualAllPrices=new ArrayList<>();
        List <Integer> expectedAllPrices=new ArrayList<>();

        for (WebElement price:allPrices){
            //System.out.println(price.getText().trim().replace("$","").replace(",",""));
            actualAllPrices.add(Integer.parseInt(price.getText().trim().replace("$","").replace(",","")));
            expectedAllPrices.add(Integer.parseInt(price.getText().trim().replace("$","").replace(",","")));

            System.out.println(Integer.parseInt(price.getText().trim().replace("$","").replace(",","")));
            System.out.println(Integer.parseInt(price.getText().trim().replace("$","").replace(",","")));
        }
        Collections.sort(expectedAllPrices);
        Assert.assertEquals(actualAllPrices,expectedAllPrices);










    }




}
