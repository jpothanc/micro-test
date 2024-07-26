package com.ib.it.productservice.test.integration.bdd.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class EquityControllerDefs extends CucumberBootstrap {

    public EquityControllerDefs() {
        System.out.println("EquityControllerDefs constructor");
    }

    @Given("I have a list of equities")
    public void iHaveAListOfEquities() {
        System.out.println("I have a list of equities");
    }

    @When("I request all equities")
    public void iRequestAllEquities() {
        System.out.println("I request all equities");
        response = webTestClient.get().uri("http://localhost:8080/api/v1/equity/product?productCode=0005.HK").exchange();
    }

    @Then("I should receive a list of equities")
    public void iShouldReceiveAListOfEquities() {
        response.expectStatus().isOk();
        System.out.println("I should receive a list of equities");
    }
}
