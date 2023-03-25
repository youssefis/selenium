package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeActions {
    @Test
    public void validateMessageAndColor(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        WebElement dropBox=driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[.='Drop here']"));
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,dropBox).perform();
        WebElement blueBox=driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[2]"));
        String actualColor=blueBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);

    }
    @Test
    public void validateNotAcceptableFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");
        driver.findElement(By.id("droppableExample-tab-accept")).click();
        Thread.sleep(2000);
        WebElement notAcceptableBox=driver.findElement(By.cssSelector("#notAcceptable"));
        String actualNotAcceptableBox= notAcceptableBox.getText();
        System.out.println(actualNotAcceptableBox);
        String expectedNotAcceptableBox="Not Acceptable";
        Assert.assertEquals(actualNotAcceptableBox,expectedNotAcceptableBox);
        WebElement dropHereBox=driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        String actualDropHereBox=dropHereBox.getText();
        String expectedDropHereBox="Drop here";
        Assert.assertEquals(actualDropHereBox,expectedDropHereBox);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(notAcceptableBox,dropHereBox).perform();
        actualDropHereBox=dropHereBox.getText();
        Assert.assertEquals(actualDropHereBox,expectedDropHereBox);

    }
}
