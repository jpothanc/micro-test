package com.ib.it.productservice.helpers;

import com.ib.it.productservice.models.Equity;
import com.ib.it.productservice.test.config.Constants;
import interfaces.ApiConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class EquityTestHelper {

    public static WebTestClient.ResponseSpec deleteEquity(String productCode, WebTestClient webTestClient, ApiConfig apiConfig) {

        String url = UriComponentsBuilder.fromUriString(apiConfig.getApiUrl(Constants.Api.EQUITY_CREATE, ""))
                .queryParam("code", productCode)
                .toUriString();

        return webTestClient.post().uri(url)
                .accept(APPLICATION_JSON)
                .exchange();

    }

    public static WebTestClient.ResponseSpec createEquity(String productCode, WebTestClient webTestClient, ApiConfig apiConfig) {

        var newEquity = EquityTestHelper.getNewEquity(productCode);
        var url = apiConfig.getApiUrl(Constants.Api.EQUITY_CREATE, "");

        return webTestClient.post().uri(url)
                .accept(APPLICATION_JSON)
                .bodyValue(newEquity)
                .exchange();

    }

    private static Equity getNewEquity(String productCode) {
        return new Equity() {{
            setProductCode(productCode);
            setStockName(productCode + " Holdings plc");
            setPrimaryExchange("HKG");
            setLotSize(400);
            setLastClosePrice(BigDecimal.valueOf(144.5));
            setCurrency("HKD");
            setDay20AverageVolume(500000L);
            setDay30AverageVolume(600000L);
        }};
    }
}
