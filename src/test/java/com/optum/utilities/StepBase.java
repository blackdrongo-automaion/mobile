package com.optum.utilities;

import com.optum.pages.Elements;
import com.optum.web.Browsers;
import com.optum.web.WebActions;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;


public class StepBase {

    private String description;

    private By element;

    private HashMap<String, Object> elementmap = new HashMap<String, Object>();
    private ArrayList<String> stepDes = new ArrayList<String>();
    private HashMap<String, String> actionMap = new HashMap<String, String>();
    private HashMap<String, String> dataMap = new HashMap<String, String>();
    WebActions webactions = new WebActions();

    public void buildStep(String description, Enum action, By element) {
        this.description = description;
        this.element = element;
        stepDes.add(this.description);
        elementmap.put(this.description, this.element);
        actionMap.put(this.description, String.valueOf(action));
    }

    public void buildStep(String description, Enum action, String expected) {
        this.description = description;
        stepDes.add(this.description);
        actionMap.put(this.description, String.valueOf(action));
        dataMap.put(this.description, expected);
    }

    public void buildStep(String description, Enum action, By element, String testData) {
        this.description = description;
        this.element = element;
        stepDes.add(this.description);
        elementmap.put(this.description, this.element);
        actionMap.put(this.description, String.valueOf(action));
        dataMap.put(this.description, testData);
    }

    public void executeSteps() {
        for (String des : stepDes) {
            System.out.println(des);
            String action = actionMap.get(des);
            System.out.println(action);
            if (!action.equals("VERIFY_TITLE") || elementmap.get(des)!=null)
                Elements.searchElement((By) elementmap.get(des));
            switch (action) {
                case "CLICK":
                    webactions.click();
                    break;
                case "TYPE":
                    webactions.type(dataMap.get(des));
                    break;
                case "VERIFY_TITLE":
                    Assert.assertEquals(Browsers.get_Title(), dataMap.get(des));
                    break;
                case "VERIFY_TEXT":
                    Assert.assertEquals(webactions.get_text(), dataMap.get(des));
                    break;
            }
        }
    }
}
