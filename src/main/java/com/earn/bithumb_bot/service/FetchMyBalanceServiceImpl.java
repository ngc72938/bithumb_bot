package com.earn.bithumb_bot.service;

import com.earn.bithumb_bot.dto.BalanceInfo;
import com.earn.bithumb_bot.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class FetchMyBalanceServiceImpl implements FetchMyBalanceService {
    private final WebClient webClient = WebClient.create("https://api.bithumb.com/");
    private final BalanceRepository balanceRepository;

    @Value("${bithumb.api.key}")
    private String key;

    @Value("${bithumb.api.secret}")
    private String secret;


    @Override
    public BalanceInfo fetchMyBalance() {
        String param = "{" +
                "\"apiKey\": \"" + key + "\" " +
                "\"secretKey\": \"" + secret + "\" ," +
                "\"currency\": \"ALL\"" +
                "}";

        BalanceInfo result = webClient.post()
                .uri("info/balance")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(param))
                .retrieve()
                .bodyToMono(BalanceInfo.class)
                .block();

        return result;
    }
}
