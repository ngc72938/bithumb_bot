package com.earn.bithumb_bot.repository;

import com.earn.bithumb_bot.entity.ApiResponseCoinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiResponseCoinDataRepository extends JpaRepository<ApiResponseCoinData, Long> {
    @Query(value = "select * from api_response_coin_data a" +
            " group by a.name , a.created_at " +
            " order by a.created_at desc" +
            " limit 30"
            ,nativeQuery = true)
    List<ApiResponseCoinData> getLastPrice();
}
