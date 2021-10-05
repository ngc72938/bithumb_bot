package com.earn.bithumb_bot.service;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;

public interface FetchCoinInfoService {
    CurrentCoinInfo fetchCoinInfo(String coinName);
}
