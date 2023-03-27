package com.test.etsy.tests;

import com.test.etsy.pages.EtsyHomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsySearchBarFunctionality extends TestBaseEtsy {

    @Parameters({"searchedPhone", "text1", "text2", "text3"})
    @Test
    public void validateSearchBarFunctionality(String searchedPhone,String text1,String text2,String text3) {
        EtsyHomePage etsyHomePage = new EtsyHomePage(driver);
        etsyHomePage.searchFunctionality(searchedPhone,text1,text2,text3);
    }

}
