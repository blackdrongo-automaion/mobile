package com.optum.web;


import org.openqa.selenium.By;

public interface StepBase {


    default void buildStep(String description, WebAppActions action, By element) {}

    default void buildStep(String description, WebAppActions action, String expected) {}

    default void buildStep(String description, WebAppActions action, By element, String testData) {}

    default void executeSteps() {}

}
