package com.rishabh.exchangeRate.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "rates")
public class ExchangeRate {
    private String date;
    private Map<String, Double> currencies;

    public ExchangeRate(String date, Map<String, Double> currencies) {
        this.date = date;
        this.currencies = currencies;
    }

    public ExchangeRate() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Double> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Double> currencies) {
        this.currencies = currencies;
    }
}
