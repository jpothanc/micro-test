package com.ib.it.productservice.test.integration.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "microservices/productservice/src/main/resources/features",
        glue = "com.ib.it.productservice.test.integration.bdd.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        monochrome = true

)
public final class RunCucumberTest {
    public RunCucumberTest() {
        System.out.println("RunCucumberTest constructor");
    }
}
