package com.optum.baseTest;


import com.optum.web.Browsers;



public class OptumAppBaseTest extends Browsers{

    public void setUp() throws Exception {
        init_browser().OpenUrl();

    }

    public void tearDown(){
        getDriver().quit();
    }

}
