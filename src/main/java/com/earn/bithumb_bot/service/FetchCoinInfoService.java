package com.earn.bithumb_bot.service;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;
import com.earn.bithumb_bot.entity.ApiResponseCoinData;

import java.util.List;

public interface FetchCoinInfoService {
    CurrentCoinInfo fetchCoinInfo(String coinName);

    List<ApiResponseCoinData> save(List<ApiResponseCoinData> list);
}
