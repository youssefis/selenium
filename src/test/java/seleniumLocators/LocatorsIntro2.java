package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) {
        System.setProperty("webDriver.chrome.driver","chromeDriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/User/Downloads/Techtorialhtml.html");

        //LinkedText Locator
//        WebElement javaLink=driver.findElement(By.linkText("Java")); //a tag with the text
//        javaLink.click();
//        WebElement header=driver.findElement(By.tagName("h1"));
//        System.out.println(header.getText().trim().equals("Java")? "Passed" : "Failed");
//        driver.navigate().back();

        /*
        -click selenium and validate (ternary) header
        and go back to homePage,do the same thing with cucumber,TestNG
        then validate the url
         */
        driver.findElement(By.linkText("Java")).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText().trim().equals("Java")?"Passed":"Failed");
        driver.navigate().back();
        driver.findElement(By.linkText("Selenium")).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText().trim().equals("Selenium automates browsers. That's it!")?"Selenium Passed":"Selenium Failed");
        driver.navigate().back();
        driver.findElement(By.linkText("Cucumber")).click();
        System.out.println(driver.findElement(By.tagName("h1")).getText().trim().equals("Tools & techniques that elevate teams to greatness")?"Cucumber Passed":"Cucumber Failed");
        driver.navigate().back();
        driver.findElement(By.linkText("TestNG")).click();
        System.out.println(driver.findElement(By.tagName("h2")).getText().trim().equals("TestNG")?"TestNG Passed":"TestNG Failed");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl().equals("file:///C:/Users/User/Downloads/Techtorialhtml.html")?"Url Passed":"Url Failed");

        // Partial Link Text Locator: //must have a tag and text

        WebElement restApi=driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        String actualUrlRestApi=driver.getCurrentUrl();
        String expectedUrlRestApi="https://rest-assured.io/";
        System.out.println(actualUrlRestApi.equals(expectedUrlRestApi)?"Passed":"Failed");
        driver.close();







    }

}
