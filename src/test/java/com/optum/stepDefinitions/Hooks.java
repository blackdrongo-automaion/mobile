package com.optum.stepDefinitions;

import com.optum.baseTest.OptumAppBaseTest;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class Hooks extends OptumAppBaseTest {

    @AfterStep
    public void addScreenshot(Scenario scenario){

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }
    /*
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");

    }*/
}
