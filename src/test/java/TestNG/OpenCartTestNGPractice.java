package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenCartTestNGPractice {
    //Task1
    //1-Login successfully with "demo" username and password,and validate title.

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void negativeLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("dimo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("dimo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//div[@id='alert']"));
        String actualMessage = message.getText();
        String expectedMessage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void productValidation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Catalog')]")).click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        Assert.assertTrue(productButton.isDisplayed());
    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        //validate that box is displayed
        //validate that box is enabled
        //click the box
        //validate that box is selected
        //Arrow down

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Catalog')]")).click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();
        Thread.sleep(2000);
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < allBoxes.size(); i++) {
            Thread.sleep(1000);
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertTrue(allBoxes.get(i).isEnabled());
            Assert.assertFalse(allBoxes.get(i).isSelected());
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);


        }

    }

    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Catalog')]")).click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();
        driver.findElement(By.cssSelector(".asc")).click(); // making products descending order
        Thread.sleep(2000);
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//td[@class='text-start']")); // 11 elements

        List<String> actualList = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();

        for (int i = 1; i < listOfProducts.size(); i++) {

            actualList.add(listOfProducts.get(i).getText().toLowerCase().trim());
            expectedList.add(listOfProducts.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedList); //sorting to ascending
        Collections.reverse(expectedList); //making expected descending
        System.out.println(actualList);
        System.out.println(expectedList);

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void validateProductNameFunctionality() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");
        driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Catalog')]")).click();
        Thread.sleep(2000);
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();
        List<WebElement> listOfProducts = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualList = new ArrayList<>();
        List<String> expectedList = new ArrayList<>();
        for (int i = 1; i < listOfProducts.size(); i++) {

            actualList.add(listOfProducts.get(i).getText().toLowerCase().trim());
            expectedList.add(listOfProducts.get(i).getText().toLowerCase().trim());

        }
        Collections.sort(expectedList);
        Assert.assertEquals(actualList, expectedList);


    }


}
