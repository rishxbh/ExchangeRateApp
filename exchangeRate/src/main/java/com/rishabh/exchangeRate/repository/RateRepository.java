package com.rishabh.exchangeRate.repository;

import com.rishabh.exchangeRate.models.ExchangeRate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends MongoRepository<ExchangeRate, String> {
    ExchangeRate findByDate(String date);
}
