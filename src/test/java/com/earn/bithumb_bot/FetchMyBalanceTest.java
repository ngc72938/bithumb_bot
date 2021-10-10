package com.earn.bithumb_bot;

import com.earn.bithumb_bot.entity.Balance;
import com.earn.bithumb_bot.service.FetchMyBalanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FetchMyBalanceTest {
    @Autowired
    private FetchMyBalanceService fetchMyBalanceService;

    @Test
    void fetchMyBalance() {
        Balance res = fetchMyBalanceService.fetchMyBalance().getData();
        System.out.println(res);
    }
}
