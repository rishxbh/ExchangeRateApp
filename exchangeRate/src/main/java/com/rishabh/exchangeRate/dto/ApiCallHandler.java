package com.rishabh.exchangeRate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class ApiCallHandler {
    private String result;
    private Map<String, Double> conversion_rates;
    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @JsonProperty("conversion_rates")
    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(HashMap<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
    public ApiCallHandler() {
    }
}
