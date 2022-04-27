package com.optum.stepDefinitions;

import com.optum.pages.Page1;
import com.optum.utilities.StepBase;
import com.optum.web.WebAppActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import static com.optum.web.Browsers.OpenUrl;


public class StepDefinition {

    @Given("^user is on Google Home Page$")
    public void user_is_on_demoQA_Home_Page() {
        OpenUrl();
    }

    @Then("^validate search results$")
    public void validate_yes_radio_is_selected() {
        StepBase step = new StepBase();
        step.buildStep("Enter the text in search box", WebAppActions.TYPE, Page1.search, "Automation");
        step.buildStep("Click on search box", WebAppActions.CLICK, Page1.searchbutton);
        //step.buildStep("Click on link box", WebAppActions.CLICK, Page1.link);
        step.buildStep("Verify Title Present", WebAppActions.VERIFY_TITLE, "Automation - Google Search");
        step.buildStep("Verify Text Present", WebAppActions.VERIFY_TEXT, Page1.text,"Automation ");
        step.executeSteps();
    }

    @Then("^verify title$")
    public void verifytitle() {
        StepBase step = new StepBase();
        step.buildStep("Enter the text in search box", WebAppActions.TYPE, Page1.search, "Automation");
        step.buildStep("Click on search box", WebAppActions.CLICK, Page1.searchbutton);
        //step.buildStep("Click on link box", WebAppActions.CLICK, Page1.link);
        step.buildStep("Verify Title Present", WebAppActions.VERIFY_TITLE, "Automation - Google Search");
        step.executeSteps();
    }

}
