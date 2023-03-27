package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){ //it will run after everything -> it clears the caches and cookies
        System.out.println("I am before suite Annotation");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test annotation");
    }
    @BeforeClass
    public void beforeClass(){// it runs before every class and people use it to lunch their browser driver=DriverHelper.getDriver()
        System.out.println("I am beforeClass annotation");
    }

    @BeforeMethod
    public void beforeMethod(){//it runs before every test annotation and it is good to use for setting up your automation
        //TESTBASE CLASS
        System.out.println("I am before Method");
    }

    @Test // it executes the codes
    public void test(){
        System.out.println("I am test annotation");
    }

    @Test
    public void test1(){
        System.out.println("I'm second test annotation");
    }

    @AfterMethod //it runs after every test annotation and it is good  to use for take screenShot and quit your driver.
    public void afterMethod(){
        System.out.println("I am after method annotation");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after test annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after suite Annotation");
    }

}
