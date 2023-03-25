package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techlist {
    /*
            1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
        2-Enter first and last name (textbox).
        3-Select gender (radio button).
        4-Select years of experience (radio button).
        5-Enter date.(send keys)
        6-Select Profession (Checkbox).
        7-Select Automation tools you are familiar with (multiple checkboxes).
        8-Select Continent(Send Keys).
        9-Click on Submit button.
        Try your own logic and automate it without any help.
     */
    public static void main(String[] args) {
        // set up my automation
        System.setProperty("webDriver.chrome.driver","chromeDriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //navigate the website
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //find the element
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Yusuf");
        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Hosaini");
        WebElement gender=driver.findElement(By.id("sex-0"));
        gender.click();
        WebElement yearsOfExperience=driver.findElement(By.id("exp-1"));
        yearsOfExperience.click();
        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("2/17/2023");
        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-2")).click();
        driver.findElement(By.id("continents")).sendKeys("North America");
        driver.findElement(By.className("btn-info")).click();


    }



}
