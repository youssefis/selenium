package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {
    @Test
    public void validateFistOptionAndPrintAllOption() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/User/Downloads/Techtorialhtml.html");
        WebElement countriesBox=driver.findElement(By.xpath("//select[@name='country']"));
        Select countries=new Select(countriesBox);
        String actualFirstSelectedOption=countries.getFirstSelectedOption().getText().trim(); //UNITED STATES
        String expectedFirstSelectedOption="UNITED STATES ".trim();
        Assert.assertEquals(actualFirstSelectedOption,expectedFirstSelectedOption);
        List<WebElement> allTheCountries=countries.getOptions();
        int c=0;
        for(WebElement countryName:allTheCountries){

            System.out.println(countryName.getText().trim());
            c++;
        }
        System.out.println(c);
        countries.selectByVisibleText("MOROCCO");
        Thread.sleep(2000);
        countries.selectByValue("42");
        Thread.sleep(2000);
        countries.selectByIndex(0);
    }

    @Test
    public void multiSelect() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/User/Downloads/Techtorialhtml.html");
        WebElement countryBox=driver.findElement(By.cssSelector(".select"));
        Select country=new Select(countryBox);
        country.selectByVisibleText("One");
        Thread.sleep(2000);
        country.selectByValue("3");
        Thread.sleep(2000);
        country.selectByIndex(4);
        Thread.sleep(2000);
        country.deselectByVisibleText("One");
        Thread.sleep(2000);
        country.deselectAll();

    }

        /*
    1-Navigate to the website
    2-Select one way trip button
    3-Choose 4 passangers(1 wife-1 husband-2 kids)
    4-Validate the depart from is default "Acapulco"
    5-Choose the depart from is Paris
    6-Choose the date August 15th
    7-Choose the arrive in is San Francisco
    8-Choose the date December 15th
    10-Click first class option.
    11-Validate All the options from Airline
    12-Choose the Unified option from airline list
    13-Click Continue
    14-Validate the message at the top.There is a bug here/
    "After flight finder - No Seats Avaialble"

    NOTE:Your test should fail and say available is not matching with Available.
    NOTE2:You can use any select method value,visibleText
    */
    @Test
    public void validateOrderMessage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.findElement(By.xpath("//input[@value='oneway']")).click();
        WebElement passengerCountOptions=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select numberOfPassenger=new Select(passengerCountOptions);
        numberOfPassenger.selectByVisibleText("4");
        WebElement departingPortOptions=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingPort=new Select(departingPortOptions);
        String actualDefaultDepart = departingPort.getFirstSelectedOption().getText().trim();
        String expectedDefaultDepart= "Acapulco";
        Assert.assertEquals(actualDefaultDepart,expectedDefaultDepart);
        departingPort.selectByValue("Paris");
        WebElement fromMonthOptions=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonth=new Select(fromMonthOptions);
        fromMonth.selectByIndex(7);
        WebElement fromDayOptions=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDay=new Select(fromDayOptions);
        fromDay.selectByVisibleText("15");
        WebElement toPortOptions=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toPort=new Select(toPortOptions);
        toPort.selectByIndex(6);
        WebElement toMonthOptions=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonth=new Select(toMonthOptions);
        toMonth.selectByIndex(11);
        WebElement toDayOptions=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDay=new Select(toDayOptions);
        toDay.selectByIndex(14);
        driver.findElement(By.xpath("//input[@value='First']")).click();
        WebElement airlineOption=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(airlineOption);
        List<WebElement> airlineOptions=airline.getOptions();
        List<String> expectedAirlineOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for (int i=0;i<airlineOptions.size();i++){
            Assert.assertEquals(airlineOptions.get(i).getText().trim(),expectedAirlineOptions.get(i));
        }
        airline.selectByVisibleText("Unified Airlines");
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();
        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=message.getText().trim();
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
    @Test
    public void shortCutSelectClass(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        driver.findElement(By.xpath("//input[@value='oneway']")).click();
        WebElement passengerCountOptions=driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerCountOptions,"4","text");
//        Select numberOfPassenger=new Select(passengerCountOptions);
//        numberOfPassenger.selectByVisibleText("4");
        WebElement departingPortOptions=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingPort=new Select(departingPortOptions);
        String actualDefaultDepart = departingPort.getFirstSelectedOption().getText().trim();
        String expectedDefaultDepart= "Acapulco";
        Assert.assertEquals(actualDefaultDepart,expectedDefaultDepart);
        BrowserUtils.selectBy(departingPortOptions,"Paris","text");
//        departingPort.selectByValue("Paris");
        WebElement fromMonthOptions=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonthOptions,"7","index");
//        Select fromMonth=new Select(fromMonthOptions);
//        fromMonth.selectByIndex(7);
        WebElement fromDayOptions=driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(fromDayOptions,"15","text");
//        Select fromDay=new Select(fromDayOptions);
//        fromDay.selectByVisibleText("15");
        WebElement toPortOptions=driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(toPortOptions,"6","index");
//        Select toPort=new Select(toPortOptions);
//        toPort.selectByIndex(6);
        WebElement toMonthOptions=driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(toMonthOptions,"11","index");
//        Select toMonth=new Select(toMonthOptions);
//        toMonth.selectByIndex(11);
        WebElement toDayOptions=driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(toDayOptions,"14","index");
//        Select toDay=new Select(toDayOptions);
//        toDay.selectByIndex(14);
        driver.findElement(By.xpath("//input[@value='First']")).click();
        WebElement airlineOption=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airline=new Select(airlineOption);
        List<WebElement> airlineOptions=airline.getOptions();
        List<String> expectedAirlineOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for (int i=0;i<airlineOptions.size();i++){
            Assert.assertEquals(airlineOptions.get(i).getText().trim(),expectedAirlineOptions.get(i));
        }
        airline.selectByVisibleText("Unified Airlines");
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();
        WebElement message=driver.findElement(By.xpath("//font[@size='4']"));
        //String actualMessage=message.getText().trim();
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }




}
