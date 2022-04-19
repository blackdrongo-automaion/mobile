package com.optum.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Test1 {

    @Given("I navigate to")
    public void i_navigate_to() {
        System.out.println("Start");
    }

    @Then("click on something")
    public void i_n() {
        System.out.println("Start");
    }

}
