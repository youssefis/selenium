package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {

    //ID LOCATOR

    public static void main(String[] args) throws InterruptedException {

       System.setProperty("webDriver.chrome.driver","chromeDriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.navigate().to("file:///C:/Users/User/Downloads/Techtorialhtml.html");
       WebElement header=driver.findElement(By.id("techtorial1"));
       String actualHeader=header.getText().trim(); //Techtorial Academy
       String expectedHeader="Techtorial Academy";
       System.out.println(actualHeader);
       System.out.println(actualHeader.equals(expectedHeader)?"Passed":"Failed");
       WebElement paragraph=driver.findElement(By.id("details2"));
       System.out.println(paragraph.getText().trim());

    //NAME LOCATOR
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Yusuf");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("hosaini");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("00000000");
        WebElement email=driver.findElement(By.name("userName"));
        email.sendKeys("yusuf@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("8535 chicago il");
        WebElement address2=driver.findElement(By.name("address2"));
        address2.sendKeys("Apt 1n");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("60634");
        Thread.sleep(3000);

        //CLASS LOCATOR

        WebElement checkboxesLabel=driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxesLabel.getText());
        WebElement javaBox=driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed()&&!javaBox.isSelected()){
            javaBox.click();
        }
        WebElement SeleniumBox=driver.findElement(By.id("cond2"));
        if (SeleniumBox.isDisplayed()&&!SeleniumBox.isSelected()){
            SeleniumBox.click();
        }
        WebElement testNgbox=driver.findElement(By.id("cond3"));
        if (testNgbox.isDisplayed()&&!testNgbox.isSelected()){
            testNgbox.click();
        }
        WebElement cucumberBox=driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed()&&!cucumberBox.isSelected()){
            cucumberBox.click();
        }

        //TAG NAME LOCATOR:

        WebElement version=driver.findElement(By.tagName("u"));
        String actualVersion=version.getText().trim();
        String expctedVersion="Use Java Version";
        System.out.println(actualVersion.equals(expctedVersion)?"Validation is passed":"Validation is failed");














    }

}
