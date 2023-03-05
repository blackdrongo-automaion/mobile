package com.optum.runners;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/Feature/test.feature"},
        glue = {"com.optum.stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true
)

public class RunCukeTest extends CucumberBaseTest {

}
