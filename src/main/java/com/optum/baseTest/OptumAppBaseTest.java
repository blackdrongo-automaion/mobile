package com.optum.baseTest;


import com.optum.mobile.AppLauncher;



public class OptumAppBaseTest extends AppLauncher {

    public static void setUp() throws Exception {
        init();
    }

    public void tearDown(){
        getDriver().quit();
    }

}
