package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }

    @Test
    public void Hello1(){
        System.out.println("test1");
    }

    @Test
    public void Hello2(){
        System.out.println("test2");
    }

    @Test
    public void Hello3(){
        System.out.println("test3");
    }
}
