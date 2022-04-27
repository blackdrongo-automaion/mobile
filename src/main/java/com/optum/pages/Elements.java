package com.optum.pages;

import com.optum.web.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends Browsers{
    private static WebElement element;
    private static By ele = null;


    public static void searchElement(By ele){
        Elements.ele = ele;
        element =Browsers.getDriver().findElement(ele);
    }

    public static WebElement getElement(){
        return Elements.element;
    }

    public static By getByObject(){
        return Elements.ele;
    }

}
