package com.optum.mobile;


import org.openqa.selenium.By;

public interface StepBase {


    default void buildStep(String description, AppActions action, By element) {}

    default void buildStep(String description, AppActions action, String expected) {}

    default void buildStep(String description, AppActions action, By element, String testData) {}

    default void executeSteps() {}

}
