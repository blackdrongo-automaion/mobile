package com.optum.mobile;

import com.optum.pages.Elements;
import com.optum.utils.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class Actions extends Elements {

    public void click(WebElement element){
        Waits.waitForElementToBeClickable(element);
        element.click();
    }

    public void type(WebElement element, String value){
        Waits.waitForElementVisibility(element);
        element.sendKeys(value);
    }

    public String get_text(WebElement element){
        Waits.waitForElementVisibility(element);
        return element.getText();
    }
    public void clear(WebElement element){
        Waits.waitForElementVisibility(element);
        element.clear();
    }

    public void java_script_click(WebElement element){
        Waits.waitForElementVisibility(element);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public void java_script_type(WebElement element){
        Waits.waitForElementVisibility(element);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].value='"+ "" +"';", element);
    }

    public void check(WebElement element){
        Waits.waitForElementVisibility(element);
        if(!element.isSelected()){
            element.click();
        }
    }

    public void unCheck(WebElement element){
        Waits.waitForElementVisibility(element);
        if(element.isSelected()){
            element.click();
        }
    }

    public static class Waits{

        static Properties prop = Utility.readProperty("config.properties");
        public static Duration time = Duration.ofSeconds(Integer.parseInt(prop.getProperty("browser.element.wait.time")));

        public static void waitForElementVisibility(WebElement element){
            WebDriverWait wait = new WebDriverWait(getDriver(), time);
            wait.until(ExpectedConditions.visibilityOf(element));
        }

        public static void waitForElementToBeClickable(WebElement element){
            WebDriverWait wait = new WebDriverWait(getDriver(),time);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }
}


