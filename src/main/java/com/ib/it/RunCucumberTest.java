package com.ib.it;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;
@Cucumber
@CucumberOptions(
        features = "src/test/resources/cucumber",
        glue = "com.ib.it.productservice.tests.integration.bdd.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunCucumberTest {
    public RunCucumberTest() {
        System.out.println("RunCucumberTest constructor");
    }
}
