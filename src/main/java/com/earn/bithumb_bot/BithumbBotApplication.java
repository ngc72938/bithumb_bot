package com.earn.bithumb_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BithumbBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BithumbBotApplication.class, args);
    }

}
