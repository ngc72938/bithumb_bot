package com.earn.bithumb_bot.repository;

import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import com.earn.bithumb_bot.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

}
