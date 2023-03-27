package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("firstName")
    @Test
    public void test(String firstName){
        System.out.println(firstName);
    }
    @Parameters({"country","city","zipcode"})
    @Test
    public void test2(String country,String city,String zipcode){

        System.out.println(country);
        System.out.println(city);
        System.out.println(zipcode);

    }
}
