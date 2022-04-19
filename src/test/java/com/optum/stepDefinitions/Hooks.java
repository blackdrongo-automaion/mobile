package com.optum.stepDefinitions;


import com.optum.baseTest.OptumAppBaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends OptumAppBaseTest {


    @Before
    public void start() throws Exception {
        setUp();
    }

    @After
    public void finish(){
        tearDown();
    }

}
