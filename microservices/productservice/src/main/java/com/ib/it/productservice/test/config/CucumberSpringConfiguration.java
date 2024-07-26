package com.ib.it.productservice.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//This file is not relevant now, might be useful later
@Configuration
@ComponentScan(basePackages = "com.ib.it.productservice")
public class CucumberSpringConfiguration {
    public CucumberSpringConfiguration() {
        System.out.println("CucumberSpringConfiguration constructor");
    }
}
