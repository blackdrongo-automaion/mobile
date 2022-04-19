package com.optum.web;

import com.optum.pages.Elements;
import com.optum.pages.WebPage;

import java.util.ArrayList;
import java.util.HashMap;


public class StepBase {

    private String description;

    public static WebPage ele;
    private Enum action;
    private WebPage element;

    private HashMap<String, String> stepBuilder = new HashMap<String, String>();
    private ArrayList<String> stepDes = new ArrayList<String>();
    private HashMap<String, Object> actionMap = new HashMap<String, Object>();
    private HashMap<Object, String> elementmap = new HashMap<Object, String>();


    public void buildStep(String description, Enum action, WebPage element) {
        this.action = action;
        this.description = description;
        this.element = element;
        stepDes.add(this.description);
        actionMap.put(this.description, this.element);
        System.out.println(WebPage.locator);
        elementmap.put(this.element, String.valueOf(WebPage.locator));
        stepBuilder.put(this.description, String.valueOf(action));
    }

    public void executeSteps(){
        try {
            for (String des : stepDes) {
                System.out.println(des);
                String action = stepBuilder.get(des);
                ele = (WebPage) actionMap.get(des);
                System.out.println(action);
                System.out.println(ele);
                Elements.searchElement(ele, (String) elementmap.get(ele));
                WebActions webactions = new WebActions();

                switch (action){
                    case "CLICK":
                        webactions.click();
                        break;
                    case "TYPE":
                        webactions.type("test");
                        break;
                }
                Thread.sleep(5000);
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }


}
