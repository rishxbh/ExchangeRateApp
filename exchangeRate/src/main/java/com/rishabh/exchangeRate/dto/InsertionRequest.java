package com.rishabh.exchangeRate.dto;

import java.util.HashMap;

public class InsertionRequest {
    private String date;
    private HashMap<String, Double> currencies;

    public InsertionRequest(String date, HashMap<String, Double> currencies) {
        this.date = date;
        this.currencies = currencies;
    }

    public InsertionRequest() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap<String, Double> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(HashMap<String, Double> currencies) {
        this.currencies = currencies;
    }
}
