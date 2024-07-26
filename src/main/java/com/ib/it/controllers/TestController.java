package com.ib.it.controllers;


import com.ib.it.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tests")
public class TestController {
    private TestService testService;
    @Autowired
    TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/run")
    public String runTests(@RequestParam String packageName) {
        packageName = packageName == null ? "com.ib.it.productservice.tests" : packageName;
        return this.testService.runTests(packageName);
    }
}

