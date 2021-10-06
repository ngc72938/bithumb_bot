package com.earn.bithumb_bot.service;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;
import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import com.earn.bithumb_bot.repository.ApiResponseCoinDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchCoinInfoServiceImpl implements FetchCoinInfoService{
    private final WebClient webClient = WebClient.create("https://api.bithumb.com/");
    private final ApiResponseCoinDataRepository apiResponseCoinDataRepository;

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

    @Override
    public List<ApiResponseCoinData> save(List<ApiResponseCoinData> list) {
        return apiResponseCoinDataRepository.saveAll(list);
    }

    @Override
    public List<ApiResponseCoinData> getLastData() {
        return apiResponseCoinDataRepository.getLastPrice();
    }
}
