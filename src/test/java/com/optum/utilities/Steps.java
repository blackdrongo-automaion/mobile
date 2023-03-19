package com.optum.utilities;

import com.optum.pages.Elements;
import com.optum.mobile.AppLauncher;
import com.optum.mobile.Actions;
import com.optum.mobile.AppActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.HashMap;


public class Steps implements com.optum.mobile.StepBase {

    private String description;
    private WebElement element;
    private final HashMap<String, Object> elementMap = new HashMap<>();
    public final ArrayList<String> stepDes = new ArrayList<>();
    public final HashMap<String, String> actionMap = new HashMap<>();
    public final HashMap<String, String> dataMap = new HashMap<>();
    Actions webactions = new Actions();

    public void buildStep(String description, AppActions action, WebElement element) throws InterruptedException {
        this.description = description;
        this.element = element;
        stepDes.add(this.description);
        elementMap.put(this.description, this.element);
        actionMap.put(this.description, String.valueOf(action));
        executeSteps();
    }

    public void buildStep(String description, AppActions action, String expected) throws InterruptedException {
        this.description = description;
        stepDes.add(this.description);
        actionMap.put(this.description, String.valueOf(action));
        dataMap.put(this.description, expected);
        executeSteps();
    }

    public void buildStep(String description, AppActions action, WebElement element, String testData) throws InterruptedException {
        this.description = description;
        this.element = element;
        stepDes.add(this.description);
        elementMap.put(this.description, this.element);
        actionMap.put(this.description, String.valueOf(action));
        dataMap.put(this.description, testData);
        executeSteps();
    }

    public void executeSteps() throws InterruptedException {
        for (String des : stepDes) {
            System.out.println(des);
            String action = actionMap.get(des);
            System.out.println(action);
            if (!action.equals("VERIFY_TITLE") || elementMap.get(des)!=null)
            switch (action) {
                case "CLICK":
                    Thread.sleep(10000);
                    webactions.click(element);
                    break;
                case "TYPE":
                    webactions.type(element,dataMap.get(des));
                    break;
                case "VERIFY_TITLE":
                    Assert.assertEquals(AppLauncher.get_Title(), dataMap.get(des));
                    break;
                case "VERIFY_TEXT":
                    Assert.assertEquals(webactions.get_text(element), dataMap.get(des));
                    break;
            }
        }
    }
}
