package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPetStore {
    @Test
    void validateCostMatchFunctionality() throws InterruptedException {

        /*
        1-Navigate to the website "https://petstore.octoperf.com/actions/Catalog.action"
        2-choose one category and put the product_id and name as a map format(Only one of the category) then print out
        3-Go back to the main menu and choose 2 different category and choose one item from there
        4-add them into the card
        5-validate the total cost equals to the price shows at the bottom
        6-Quit
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        driver.findElement(By.xpath("//area[@alt='Fish']")).click();
        List<WebElement> allProductIds=driver.findElements(By.xpath("//td[1]"));
        List<WebElement> allProductNames=driver.findElements(By.xpath("//td[2]"));
        Map<String,String> listOfFish=new HashMap<>();
        for (int i=0;i<allProductNames.size();i++){
            listOfFish.put(BrowserUtils.getText(allProductIds.get(i)),BrowserUtils.getText(allProductNames.get(i)));
        }
        System.out.println(listOfFish);
        driver.navigate().back();
        driver.findElement(By.xpath("//area[@alt='Cats']")).click();
        driver.findElement(By.xpath("//td[.='Manx']//preceding-sibling::td//a")).click();
        driver.findElement(By.xpath("//td[contains(text(),'Tailless')]//..//td[5]")).click();
        driver.findElement(By.xpath("//a[.='Return to Main Menu']")).click();







    }
}
