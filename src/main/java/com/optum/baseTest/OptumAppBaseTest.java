package com.optum.baseTest;


import com.optum.web.Browsers;



public class OptumAppBaseTest extends Browsers{

    public static void setUp() throws Exception {
        init_browser();


    }

    public void tearDown(){
        getDriver().quit();
    }

}
