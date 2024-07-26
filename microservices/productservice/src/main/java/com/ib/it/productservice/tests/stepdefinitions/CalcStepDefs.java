package com.ib.it.productservice.tests.stepdefinitions;
import com.ib.it.productservice.tests.config.CucumberSpringConfiguration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertTrue;


@CucumberContextConfiguration
@ContextConfiguration(classes = CucumberSpringConfiguration.class)

public class CalcStepDefs {
    private int result;
    List<Integer> numbers;

    public CalcStepDefs() {
        System.out.println("CalcStepDefs constructor");
        numbers = new java.util.ArrayList<>();
    }

    @Given("I have entered {int} into the calculator")
    public void iHaveEnteredIntoTheCalculator(int arg0) {

        System.out.println("I have entered " + arg0 + " into the calculator");
        numbers.add(arg0);
    }

    @When("I press add")
    public void iPressAdd() {
        System.out.println("I press add");
       result = numbers.stream().reduce(0, Integer::sum);
    }

    @Then("the result should be {int} on the screen")
    public void theResultShouldBeOnTheScreen(int arg0) {
        System.out.println("the result should be " + arg0 + " on the screen");
        System.out.println("Passed arg0: " + arg0 + " result: " + result);
        assertTrue(result == arg0);
    }
}
