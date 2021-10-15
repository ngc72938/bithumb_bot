package com.earn.bithumb_bot.dto;

import com.earn.bithumb_bot.entity.Balance;
import lombok.Data;

@Data
public class BalanceInfo {
    private String status;

    private Balance data;
}
