package com.ib.it.productservice.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "microservices/productservice/src/main/resources/features",
        glue = "com.ib.it.productservice.tests.stepdefinitions"
)
public final class RunCucumberTest {
    public RunCucumberTest() {
        System.out.println("RunCucumberTest constructor");
    }
}
