package mentoring_with_cuba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaTest {

    @Test()
    public void ValidateEmailAndName_TC_01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement TablePaginationButton = driver.findElement(By.xpath("//a[.='Table Pagination']"));
        TablePaginationButton.click();
        WebElement selectMyRows = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(selectMyRows, "Show ALL Rows", "text");
        //storing all the names in a list
        Thread.sleep(2000);
        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));

        for (int i = 0; i < allNames.size(); i++) {
            Map<String, String>map = new HashMap<>();
            map.put(allNames.get(i).getText(), allEmails.get(i).getText());
            System.out.println(map);
        }
        List<WebElement> allPhoneNumbers = driver.findElements(By.xpath("//tr//td[4]"));

        for (int i = 0; i<allNames.size();i++){
            Map<String,Long>nameAndNumber=new HashMap<>();
            nameAndNumber.put(allNames.get(i).getText(),Long.parseLong(allPhoneNumbers.get(i).getText().replace("-","")));
            System.out.println(nameAndNumber);
        }




    }
}