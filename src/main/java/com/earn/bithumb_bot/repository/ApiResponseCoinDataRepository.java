package com.earn.bithumb_bot.repository;

import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiResponseCoinDataRepository extends JpaRepository<ApiResponseCoinData, Long> {
    @Query(value = "select * from api_response_coin_data" +
            " group by name , created_at ,fluctate_rate, id, created_at, updated_at" +
            " order by created_at desc" +
            " limit 50"
            ,nativeQuery = true)
    List<ApiResponseCoinData> getLastPrice();
}
