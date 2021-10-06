package com.earn.bithumb_bot;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;
import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import com.earn.bithumb_bot.service.FetchCoinInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class FetchCurrentCoinInfoPriceTest {
    @Autowired
    FetchCoinInfoService fetchCoinInfoService;


    @Test
    public void getCoinPrice(){
        String[] targetCoinList = {"BTC","ETH","KLAY","XEC","XTZ","QTUM","OMG","PCI","DOT","WEMIX"};
        List<ApiResponseCoinData> apiResponseCoinData = new ArrayList<>();

        Arrays.stream(targetCoinList).forEach(coinName -> {
            CurrentCoinInfo currentCoinInfo = fetchCoinInfoService.fetchCoinInfo(coinName);
            apiResponseCoinData.add(currentCoinInfo.getData());
        });

        fetchCoinInfoService.save(apiResponseCoinData);
    }

}
