package com.earn.bithumb_bot.dto;

import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import lombok.Data;

@Data
public class CurrentCoinInfo {
    private String status;

    private ApiResponseCoinData data;
}
