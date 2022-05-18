package com.optum.stepDefinitions;

import com.optum.apiengine.model.requests.RequestBodyData;
import com.optum.apiengine.model.requests.RestRequest;
import com.optum.apiengine.model.response.RestResponse;
import com.optum.baseTest.OptumAppBaseTest;
import com.optum.utils.Utility;
import io.cucumber.java.*;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;

public class Hooks extends OptumAppBaseTest {

    public static String testStatus;
    public static String[] rallyIdList;

    @Before
    public void test(Scenario scenario) {
        ArrayList<String> testId = (ArrayList<String>) scenario.getSourceTagNames();
        for (String e : testId) {
            if (e.contains("RallyId")) {
                rallyIdList = e.split(":");
                System.out.println(rallyIdList[1]);
                break;
            }
        }
    }

    @After
    public void stepStatus(Scenario scenario) {
        addScreenshot(scenario);
        //setTestCaseStatus();
    }

    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            testStatus = "Fail";
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
        testStatus = "Pass";
    }

    public void setTestCaseStatus(){
        Properties prop = Utility.readProperty("rallyconfig.properties");
        String body = new RequestBodyData("config/rally.json").updateRallyJsonValues(rallyIdList, testStatus);
        Response response = RestRequest.auth(prop.getProperty("rally.baseUri"), prop.getProperty("rally.basePath"), body);
        new RestResponse(response).getResponse();
    }

}
