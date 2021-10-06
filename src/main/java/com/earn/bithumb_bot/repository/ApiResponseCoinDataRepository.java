package com.earn.bithumb_bot.repository;

import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiResponseCoinDataRepository extends JpaRepository<ApiResponseCoinData, Long> {

}
