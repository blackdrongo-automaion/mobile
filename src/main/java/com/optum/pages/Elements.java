package com.optum.pages;

import com.optum.mobile.AppLauncher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends AppLauncher {
    private static WebElement element;
    private static By ele = null;


    public static void searchElement(By ele){
        Elements.ele = ele;
        element = AppLauncher.getDriver().findElement(ele);
    }

    public static WebElement getElement(){
        return Elements.element;
    }

    public static By getByObject(){
        return Elements.ele;
    }

}
