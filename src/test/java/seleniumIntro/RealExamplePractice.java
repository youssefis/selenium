package seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealExamplePractice {
    public static void main(String[] args) {

            //  Test Case - Open Godaddy.com and validate it's Page title and the url.
    //    Steps to Automate:
    //            1. Launch...browser of your choice say., Firefox, chrome etc.
    //            2. Open this URL - https://www.godaddy.com/
    //            3. Maximize or set size of browser window.
    //4. Get Title of page and...
    //Set up your automation
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    WebDriver driver=new ChromeDriver(); //creating an objet
    driver.manage().window().maximize(); //maximize
    driver.get("https://www.godaddy.com/"); //navigate to website;
    String actualUrl=driver.getCurrentUrl();
    String expectedUrl="https://www.godaddy.com/fr-fr#id-4ac67a5a-b603-4bd5-bdd5-580c829b2190";
    String actualTitle= driver.getTitle();
    String expectedTitle="Noms de domaine, Sites Web, Outils de marketing en ligne et d’hébergement - GoDaddy FR";

    System.out.println(actualUrl.equals(expectedUrl) ? "Url Passed" : "Url Failed");
    System.out.println(actualTitle.equals(expectedTitle) ? "Title Passed" : "Title Failed");


    driver.close();







    }
}
