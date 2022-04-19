package com.optum.web;

import com.optum.pages.Elements;
import com.optum.utils.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class WebActions extends Elements {

    WebAppActions actions;

    WebActions(){
        Waits wait = new Waits();
        wait.waitForElementVisibility();
    }

    public void click(){
        Waits.waitForElementToBeClickable();
        getElement().click();
    }

    public void type(String value){
        getElement().sendKeys(value);
    }

    public void clear(){
        getElement().clear();
    }

    public void java_script_click(){
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", getElement());
    }

    public void java_script_type(){
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].value='"+ "" +"';", getElement());
    }

    public void check(){
        if(!getElement().isSelected()){
            getElement().click();
        }
    }

    public void unCheck(){
        if(getElement().isSelected()){
            getElement().click();
        }
    }

    public static class Waits{

        static Properties prop = Utility.readProperty("config.properties");
        public static Duration time = Duration.ofSeconds(Integer.parseInt(prop.getProperty("browser.element.wait.time")));

        public void waitForElementVisibility(){
            WebDriverWait wait = new WebDriverWait(getDriver(),time);
            wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject()));
        }

        public static void waitForElementToBeClickable(){
            WebDriverWait wait = new WebDriverWait(getDriver(),time);
            wait.until(ExpectedConditions.elementToBeClickable(getElement()));
        }



    }
}


