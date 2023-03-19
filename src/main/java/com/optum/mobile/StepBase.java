package com.optum.mobile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface StepBase {


    default void buildStep(String description, AppActions action, WebElement element) throws InterruptedException {}

    default void buildStep(String description, AppActions action, String expected) throws InterruptedException {}

    default void buildStep(String description, AppActions action, WebElement element, String testData) throws InterruptedException {}

    default void executeSteps() throws InterruptedException {}

}
