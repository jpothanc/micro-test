package com.ib.it.productservice.test.integration.bdd.stepdefinitions;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseStepDefs {
     @Autowired
     protected WebTestClient webTestClient;
     protected WebTestClient.ResponseSpec response;
}