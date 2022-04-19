package com.optum.pages;

import com.optum.web.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends WebPage {
    private static WebElement element;
    private static By ele = null;


    public static WebElement searchElement(WebPage webpage, String locator){
        switch(locator){
            case "ID":
                ele = By.id(String.valueOf(webpage));
                break;
            case "NAME":
                ele = By.name(String.valueOf(webpage));
                break;
            case "CLASSNAME":
                ele = By.className(String.valueOf(webpage));
                break;
            case "CSS":
                ele = By.cssSelector(String.valueOf(webpage));
                break;
            case "TAG_NAME":
                ele = By.tagName(String.valueOf(webpage));
                break;
            case "PARTIAL_LINK_TEXT":
                ele = By.partialLinkText(String.valueOf(webpage));
                break;
            case "XPATH":
                ele = By.xpath(String.valueOf(webpage));
                break;
        }
        element =Browsers.getDriver().findElement(ele);
        return element;
    }

    public static WebElement getElement(){
        return Elements.element;
    }

    public static By getByObject(){
        return Elements.ele;
    }

}
