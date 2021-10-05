package com.earn.bithumb_bot.service;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FetchCoinInfoServiceImpl implements FetchCoinInfoService{
    private final WebClient webClient = WebClient.create("https://api.bithumb.com/");

    @Override
    public CurrentCoinInfo fetchCoinInfo(String coinName){
        CurrentCoinInfo result =  webClient.get()
                .uri("public/ticker/"+coinName+"_KRW")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(CurrentCoinInfo.class)
                .block();

        assert result != null;
        result.getData().setName(coinName);

        return result;
    }
}
