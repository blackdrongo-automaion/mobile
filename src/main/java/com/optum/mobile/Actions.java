package com.optum.mobile;

import com.optum.pages.Elements;
import com.optum.utils.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class Actions extends Elements {

    public void click(){
        Waits.waitForElementToBeClickable();
        getElement().click();
    }

    public void type(String value){
        Waits.waitForElementVisibility();
        getElement().sendKeys(value);
    }

    public String get_text(){
        Waits.waitForElementVisibility();
        return getElement().getText();
    }
    public void clear(){
        Waits.waitForElementVisibility();
        getElement().clear();
    }

    public void java_script_click(){
        Waits.waitForElementVisibility();
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", getElement());
    }

    public void java_script_type(){
        Waits.waitForElementVisibility();
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].value='"+ "" +"';", getElement());
    }

    public void check(){
        Waits.waitForElementVisibility();
        if(!getElement().isSelected()){
            getElement().click();
        }
    }

    public void unCheck(){
        Waits.waitForElementVisibility();
        if(getElement().isSelected()){
            getElement().click();
        }
    }

    public static class Waits{

        static Properties prop = Utility.readProperty("config.properties");
        public static Duration time = Duration.ofSeconds(Integer.parseInt(prop.getProperty("browser.element.wait.time")));

        public static void waitForElementVisibility(){
            WebDriverWait wait = new WebDriverWait(getDriver(), time);
            wait.until(ExpectedConditions.visibilityOfElementLocated(getByObject()));
        }

        public static void waitForElementToBeClickable(){
            WebDriverWait wait = new WebDriverWait(getDriver(),time);
            wait.until(ExpectedConditions.elementToBeClickable(getElement()));
        }
    }
}


