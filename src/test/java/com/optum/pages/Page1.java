package com.optum.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1{

    WebDriver driver;

    public Page1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    public  WebElement searchBar;

    @FindBy(name = "btnK")
    public  WebElement searchbutton;

}
