package com.earn.bithumb_bot;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;
import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import com.earn.bithumb_bot.service.FetchCoinInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class FetchCurrentCoinInfoPriceTest {
    @Autowired
    FetchCoinInfoService fetchCoinInfoService;


    @Test
    void getCoinPrice(){
        String[] targetCoinList = {
                "BTC","ETH","KLAY","XEC","XTZ","QTUM","OMG","PCI","DOT","WEMIX","DOGE","XRP","XNO","HIVE","EVZ","XLM","UNI",
                "AXS","LTC","ADA","EOS","SOL","LUNA","AERGO","ORC","ONG","SRM","SAND","XEM","PUNDIX"
        };
        List<ApiResponseCoinData> apiResponseCoinData = new ArrayList<>();

        Arrays.stream(targetCoinList).forEach(coinName -> {
            CurrentCoinInfo currentCoinInfo = fetchCoinInfoService.fetchCoinInfo(coinName);
            apiResponseCoinData.add(currentCoinInfo.getData());
        });

       List<ApiResponseCoinData> result =  fetchCoinInfoService.save(apiResponseCoinData);
        Assertions.assertNotEquals(1, result.size());
    }

}
