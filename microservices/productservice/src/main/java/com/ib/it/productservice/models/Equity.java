package com.ib.it.productservice.models;


import lombok.*;
import java.math.BigDecimal;

import static java.net.URLEncoder.encode;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Equity {

    private String productCode;

    private String stockName;

    private String primaryExchange;

    private Integer lotSize;

    private BigDecimal lastClosePrice;

    private String currency;

    private Long day20AverageVolume;

    private Long day30AverageVolume;

}
