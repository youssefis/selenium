package seleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathRealHealthProject {
    /*
        //THESE PARTS SHOULD BE DONE BY XPATH:
            1-Navigate to the https://katalon-demo-cura.herokuapp.com/
            2-Click Make an Appointment
            3-Login the username and password provided and Login successfully
            4-Choose the facility either HongKong or Seoul -->send keys
            5-Click apply for hospital admission box if it is displayed and validate it is selected
            6-Healthcare program 'Medicaid'
            7-Visit date should be provided -->send keys
            8-Put your command for this box -->send keys
            9-Book your appointment
            THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
            10-Validate the header is "Appointment confirmation" (if statement)
            11-Print out the headers and values(only values) on your console.
            12)Click go to homepage and print out url
            13)Driver.quit or close.

     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.Chrome.driver", "chromeDriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        driver.findElement(By.xpath("//select[@id='combo_facility']")).sendKeys("Seoul CURA Healthcare Center");
        //driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
        Thread.sleep(2000);
        WebElement hospitalReadmission = driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if (!hospitalReadmission.isSelected() && hospitalReadmission.isDisplayed() && hospitalReadmission.isDisplayed()) {
            hospitalReadmission.click();
        }
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
        driver.findElement(By.xpath("//input[@id='txt_visit_date']")).sendKeys("18/02/2023");
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("No comment, this is just a test");
        driver.findElement(By.xpath("//button[@id='btn-book-appointment']")).click();
        WebElement Header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
        String actualHeader = Header.getText();
        String expectedHeader = "Appointment Confirmation";
        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header Passed");
        } else {
            System.out.println("Header Failed");
        }
        System.out.println(actualHeader);
        driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]")).click();
        System.out.println(driver.getCurrentUrl());
        driver.close();


    }


}

