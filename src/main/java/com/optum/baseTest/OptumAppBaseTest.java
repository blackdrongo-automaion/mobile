package com.optum.baseTest;

import com.optum.browsers.Browsers;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class OptumAppBaseTest {
    Browsers browsers =new Browsers();

    @BeforeTest
    public void setUp() throws Exception {
        browsers.init_browser();
    }

    @AfterTest
    public void tearDown(){
        browsers.getDriver().quit();
    }

}
