package com.earn.bithumb_bot;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;
import com.earn.bithumb_bot.service.FetchCoinInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FetchCurrentCoinInfoPriceTest {
    @Autowired
    FetchCoinInfoService fetchCoinInfoService;

    @Test
    public void getCoinPrice(){
        List<String> coinList = new ArrayList<>();
        coinList.add("BTC");
        coinList.add("ETH");
        coinList.add("KLAY");
        coinList.add("XEC");
        coinList.add("XEM");
        coinList.add("XTZ");
        coinList.add("QTUM");
        coinList.add("OMG");
        coinList.add("PCI");
        coinList.add("DOT");
        coinList.add("WEMIX");

        coinList.forEach(coinName -> {
            CurrentCoinInfo currentCoinInfo = fetchCoinInfoService.fetchCoinInfo(coinName);
            System.out.println(currentCoinInfo);
        });


    }

}
