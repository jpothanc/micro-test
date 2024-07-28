package com.ib.it.productservice.test.integration.bdd.stepdefinitions;

import com.ib.it.productservice.helpers.EquityTestHelper;
import com.ib.it.productservice.test.config.Constants;
import interfaces.ApiConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class EquityControllerStepDefs extends BaseStepDefs {

    private final ApiConfig apiConfig;

    @Autowired
    public EquityControllerStepDefs(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    @Given("I have a list of equities")
    public void iHaveAListOfEquities() {
        System.out.println("I have a list of equities");
    }

    @When("I request all equities")
    public void iRequestAllEquities() {
        var url = this.apiConfig.getApiUrl(Constants.Api.EQUITY_GET_All, "");
        response = webTestClient.get().uri(url).exchange();
        System.out.println("I request all equities - " + url);
    }

    @Then("I should receive a list of equities")
    public void iShouldReceiveAListOfEquities() {
        response.expectStatus().isOk();
        System.out.println("I should receive a list of equities");
    }

    @When("I request {string} equity")
    public void iRequestEquity(String equity) {
        System.out.println("Requesting equity: " + equity);
        var url = this.apiConfig.getApiUrl(Constants.Api.EQUITY_GET_BY_CODE, "?productCode=" + equity);
        response = webTestClient.get().uri(url).exchange();
    }

    @Then("I should receive {string} equity")
    public void iShouldReceiveEquity(String equity) {
        System.out.println("Verifying received equity: " + equity);
        response.expectStatus().isOk();
    }

    @Then("I should receive product not found")
    public void iShouldReceiveProductNotFound() {
        response.expectStatus().isNotFound();
    }

    @Given("There is no equity with code {string}")
    public void thereIsNoEquityWithCodeEquity(String equity) {
        EquityTestHelper.deleteEquity(equity, webTestClient, apiConfig);
    }

    @When("I create {string} equity")
    public void iCreateEquity(String equity) {
        response = EquityTestHelper.createEquity(equity, webTestClient, apiConfig);
    }

    @Then("{string} should be created")
    public void equityShouldBeCreated(String equity) {
        response.expectStatus().isOk();
        System.out.println("Equity created: " + equity);
    }



}

