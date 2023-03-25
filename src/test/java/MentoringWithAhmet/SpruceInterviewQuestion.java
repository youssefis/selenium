package MentoringWithAhmet;

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

public class SpruceInterviewQuestion {

    @Test
    public void validateFishProduct() throws InterruptedException {

        /*
    1-Navigate to the website "https://www.thespruceeats.com/"
    2-Under Ingredients option --> choose Fish&SeaFood option
    3-ScrollDown to the search bar
    4-Send the data: "Fish for dinner"
    5-On the left side choose 4 star up option
    6-From popular: Choose the Editor's choice option
    7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
    8-Quit or close your driver
     */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.thespruceeats.com/");
        WebElement ingredientsOption=driver.findElement(By.xpath("//span[.='Ingredients']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredientsOption).perform();
        driver.findElement(By.xpath("//a[.='Fish & Seafood']")).click();
        Thread.sleep(2000);
        WebElement searchBar=driver.findElement(By.id("search-form-input"));
        actions.scrollToElement(searchBar);
        searchBar.sendKeys("Fish for dinner");
        driver.findElement(By.id("button_1-0")).click();
        Thread.sleep(2000);
        WebElement stars4Option=driver.findElement(By.xpath("//div[contains(text(),'Choice (1)')]"));
        stars4Option.click();
        Thread.sleep(2000);
        WebElement nameOfProduct=driver.findElement(By.xpath("//h4//span"));
        String actualProduct=BrowserUtils.getText(nameOfProduct);
        String expectedProduct="6-Ingredient Roasted Salmon Fillets";
        Assert.assertEquals(actualProduct,expectedProduct);
        driver.quit();







    }

}
