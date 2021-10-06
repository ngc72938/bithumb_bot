package com.earn.bithumb_bot.schedule;

import com.earn.bithumb_bot.dto.CurrentCoinInfo;
import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import com.earn.bithumb_bot.service.FetchCoinInfoService;
import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import com.slack.api.webhook.WebhookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceSchedule {
    private final FetchCoinInfoService fetchCoinInfoService;

    @Value("${slack.webhook.url}")
    private String webhookUrl;

    @Scheduled(cron = "*/50 * * * * *")
    public void savePrice(){
        String[] targetCoinList = {
                "BTC","ETH","KLAY","XEC","XTZ","QTUM","OMG","PCI","DOT","WEMIX","DOGE","XRP","XNO","HIVE","EVZ","XLM","UNI",
                "AXS","LTC","ADA","EOS","SOL","LUNA","AERGO","ORC","ONG","SRM","SAND","XEM","PUNDIX"
        };
        List<ApiResponseCoinData> apiResponseCoinData = new ArrayList<>();

        Arrays.stream(targetCoinList).forEach(coinName -> {
            CurrentCoinInfo currentCoinInfo = fetchCoinInfoService.fetchCoinInfo(coinName);
            apiResponseCoinData.add(currentCoinInfo.getData());
        });

        List<ApiResponseCoinData> lastData = fetchCoinInfoService.getLastData();

        List<ApiResponseCoinData> currentData = fetchCoinInfoService.save(apiResponseCoinData);

        currentData.forEach(currentInfo->
            lastData.forEach(lastInfo ->{
                if(currentInfo.getName().equals(lastInfo.getName())){
                    double diff = currentInfo.getFluctateRate() - lastInfo.getFluctateRate();
                    System.out.println(Math.round(diff*100)/100.00);
                    double roundDiff = Math.round(diff*100)/100.00;
                    if(roundDiff > 3){
                        sendWebhook(currentInfo.getName()+" :: "+roundDiff);
                    }
                }
            })
        );
    }

    void sendWebhook(String text){
        try {
            WebhookResponse response = null;
            Slack slack = Slack.getInstance();
            Payload payload = Payload.builder().text(text).build();
            response = slack.send(webhookUrl, payload);

            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
