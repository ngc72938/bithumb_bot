package com.earn.bithumb_bot.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "api_response_coin_data")
public class ApiResponseCoinData extends Time{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coin_data_id")
    private Long id;

    private String name;

    @JsonProperty("opening_price")
    private String openingPrice;

    @JsonProperty("closing_price")
    private String closingPrice;

    @JsonProperty("fluctate_rate_24H")
    private Double fluctateRate;
}
