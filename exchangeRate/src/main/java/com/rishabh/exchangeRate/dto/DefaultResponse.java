package com.rishabh.exchangeRate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Last One Day", "Last One Week", "Last One Month", "Last 3 Month", "Last 6 Month", "Last 9 Month", "Last 12 Month"})
public class DefaultResponse {

    private String LastOneDay;
    private String LastOneWeek;
    private String LastOneMonth;
    private String Last3Month;
    private String Last6Month;
    private String Last9Month;
    private String Last12Month;

    @JsonProperty("Last One Day")
    public String getLastOneDay() {
        return LastOneDay;
    }

    public void setLastOneDay(String lastOneDay) {
        LastOneDay = lastOneDay;
    }
    @JsonProperty("Last One Week")
    public String getLastOneWeek() {
        return LastOneWeek;
    }

    public void setLastOneWeek(String lastOneWeek) {
        LastOneWeek = lastOneWeek;
    }
    @JsonProperty("Last One Month")
    public String getLastOneMonth() {
        return LastOneMonth;
    }

    public void setLastOneMonth(String lastOneMonth) {
        LastOneMonth = lastOneMonth;
    }
    @JsonProperty("Last 3 Month")
    public String getLast3Month() {
        return Last3Month;
    }

    public void setLast3Month(String last3Month) {
        Last3Month = last3Month;
    }
    @JsonProperty("Last 6 Month")
    public String getLast6Month() {
        return Last6Month;
    }

    public void setLast6Month(String last6Month) {
        Last6Month = last6Month;
    }
    @JsonProperty("Last 9 Month")
    public String getLast9Month() {
        return Last9Month;
    }

    public void setLast9Month(String last9Month) {
        Last9Month = last9Month;
    }
    @JsonProperty("Last 12 Month")
    public String getLast12Month() {
        return Last12Month;
    }

    public void setLast12Month(String last12Month) {
        Last12Month = last12Month;
    }

    public DefaultResponse() {
    }

    public DefaultResponse(String lastOneDay, String lastOneWeek, String lastOneMonth, String last3Month, String last6Month, String last9Month, String last12Month) {
        LastOneDay = lastOneDay;
        LastOneWeek = lastOneWeek;
        LastOneMonth = lastOneMonth;
        Last3Month = last3Month;
        Last6Month = last6Month;
        Last9Month = last9Month;
        Last12Month = last12Month;
    }
}
