package com.optum.stepDefinitions;

import com.optum.mobile.AppActions;
import com.optum.mobile.AppLauncher;
import com.optum.mobile.StepBase;
import com.optum.pages.Page1;
import com.optum.utilities.Steps;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

public class StepDefinition {


    @Given("^Start Test$")
    public void user_is_on_demoQA_Home_Page() throws Exception {
        Thread.sleep(10000);
        //AppLauncher.getDriver().findElement(By.t("android.widget.Button")).click();

        Page1 page =new Page1(AppLauncher.getDriver());
        StepBase step = new Steps();
        step.buildStep("Enter the text in search box", AppActions.TYPE, page.searchBar, "Automation");
        step.buildStep("Click on search box", AppActions.CLICK, page.searchbutton);
    }
}
