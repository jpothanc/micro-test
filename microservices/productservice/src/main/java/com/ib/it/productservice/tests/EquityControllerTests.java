package com.ib.it.productservice.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EquityControllerTests {
    @Autowired
    protected WebTestClient webTestClient;

    @Test
    public void test() {
        System.out.println();
        webTestClient.get()
                .uri("http://localhost:8080/api/v1/equity/product?productCode=q0005.HK")
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }
}
