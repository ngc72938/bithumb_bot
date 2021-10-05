package com.earn.bithumb_bot.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponseCoinData {
    private String name;

    @JsonProperty("opening_price")
    private String openingPrice;

    @JsonProperty("closing_price")
    private String closingPrice;

    @JsonProperty("fluctate_rate_24H")
    private String fluctateRate;


}
