package com.earn.bithumb_bot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "balance")
public class Balance extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_id")
    private Long id;

    @JsonProperty("total_btc")
    private String totalBtc;

    @JsonProperty("total_krw")
    private String totalKrw;

    @JsonProperty("in_use_btc")
    private String inUseBtc;

    @JsonProperty("in_use_krw")
    private String inUseKrw;

    @JsonProperty("available_btc")
    private String availableBtc;

    @JsonProperty("available_krw")
    private String availableKrw;
}
