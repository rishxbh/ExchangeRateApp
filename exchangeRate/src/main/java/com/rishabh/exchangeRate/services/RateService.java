package com.rishabh.exchangeRate.services;

import com.rishabh.exchangeRate.dto.DefaultResponse;
import com.rishabh.exchangeRate.dto.InsertionRequest;
import com.rishabh.exchangeRate.models.ExchangeRate;

public interface RateService {
    DefaultResponse getTodayDiff(String currency);
    ExchangeRate postData(InsertionRequest request);

    ExchangeRate putData(InsertionRequest request);

    String deleteData(String date);
}
