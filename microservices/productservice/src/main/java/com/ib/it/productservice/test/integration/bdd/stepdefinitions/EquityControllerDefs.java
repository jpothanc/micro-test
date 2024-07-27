package com.ib.it.productservice.test.integration.bdd.stepdefinitions;

import com.ib.it.productservice.test.config.Constants;
import interfaces.ApiConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

public class EquityControllerDefs extends CucumberBootstrap {

    private final ApiConfig apiConfig;

    @Autowired
    public EquityControllerDefs(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
        System.out.println("EquityControllerDefs constructor");
    }

    @Given("I have a list of equities")
    public void iHaveAListOfEquities() {
        System.out.println("I have a list of equities");
    }

    @When("I request all equities")
    public void iRequestAllEquities() {

        var url = this.apiConfig.getApiUrl(Constants.Api.EQUITY_GET_All, "");
        System.out.println("I request all equities - " + url);
        response = webTestClient.get().uri(url).exchange();
    }

    @Then("I should receive a list of equities")
    public void iShouldReceiveAListOfEquities() {
        response.expectStatus().isOk();
        System.out.println("I should receive a list of equities");
    }

    @When("I request {string} equity")
    public void iRequestEquity(String equity) {
        System.out.println("Requesting equity: " + equity);
        var url = this.apiConfig.getApiUrl(Constants.Api.EQUITY_GET_BY_CODE, "?productCode="+ equity);
        System.out.println("I request all equities - " + url);
        response = webTestClient.get().uri(url).exchange();
    }

    @Then("I should receive {string} equity")
    public void iShouldReceiveEquity(String equity) {
        System.out.println("Verifying received equity: " + equity);
        response.expectStatus().isOk();

    }
}

