package com.rishabh.exchangeRate.services;

import com.rishabh.exchangeRate.dto.DefaultResponse;
import com.rishabh.exchangeRate.dto.InsertionRequest;
import com.rishabh.exchangeRate.models.ExchangeRate;
import com.rishabh.exchangeRate.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class RateServiceImpl implements RateService{

    @Autowired
    private RateRepository rateRepository;
    @Override
    public DefaultResponse getTodayDiff(String currency) {
        DefaultResponse response = new DefaultResponse();
        LocalDate today = LocalDate.now();
        ExchangeRate todayExchangeRate = rateRepository.findByDate(today.toString());
        Map<String, Double> todayCurrencies = todayExchangeRate.getCurrencies();
        Double todayRate = todayCurrencies.get(currency);

        LocalDate dayAgo = today.minusDays(1);
        response.setLastOneDay(getDiff(todayRate, dayAgo, currency));
        LocalDate weekAgo = today.minusWeeks(1);
        response.setLastOneWeek(getDiff(todayRate, weekAgo, currency));
        LocalDate monthAgo = today.minusMonths(1);
        response.setLastOneMonth(getDiff(todayRate, monthAgo, currency));
        LocalDate threeMonthAgo = today.minusMonths(3);
        response.setLast3Month(getDiff(todayRate, threeMonthAgo, currency));
        LocalDate sixMonthAgo = today.minusMonths(6);
        response.setLast6Month(getDiff(todayRate, sixMonthAgo, currency));
        LocalDate nineMonthAgo = today.minusMonths(9);
        response.setLast9Month(getDiff(todayRate, nineMonthAgo, currency));
        LocalDate twelveMonthAgo = today.minusMonths(12);
        response.setLast12Month(getDiff(todayRate, twelveMonthAgo, currency));
        return response;
    }
    public String getDiff(Double todayRate, LocalDate diffDate, String currency) {
        ExchangeRate diffDateExchangeRate = null;
        if(diffDate != null) {
            diffDateExchangeRate = rateRepository.findByDate(diffDate.toString());
        }
        if(diffDateExchangeRate == null) {
            return "No Data Found";
        } else {
            Map<String, Double> diffDateCurrencies = diffDateExchangeRate.getCurrencies();
            Double diffDateRate = diffDateCurrencies.get(currency);
            double percentage = ((todayRate - diffDateRate) / diffDateRate) * 100;
            return todayRate > diffDateRate ? "+"+ percentage : "" + percentage;
        }
    }

    @Override
    public ExchangeRate postData(InsertionRequest request) {
        if(rateRepository.findByDate(request.getDate()) == null) {
            ExchangeRate exchangeRate = new ExchangeRate(request.getDate(), request.getCurrencies());
            return rateRepository.save(exchangeRate);
        } else {
            return null;
        }
    }

    @Override
    public ExchangeRate putData(InsertionRequest request) {
        if(rateRepository.findByDate(request.getDate()) != null) {
            ExchangeRate exchangeRate = rateRepository.findByDate(request.getDate());
            exchangeRate.setCurrencies(request.getCurrencies());
            return rateRepository.save(exchangeRate);
        } else {
            return null;
        }
    }

    @Override
    public String deleteData(String date) {
        if(rateRepository.findByDate(date) != null) {
            ExchangeRate exchangeRate = rateRepository.findByDate(date);
            rateRepository.delete(exchangeRate);
            return "Deleted Successfully";
        } else {
            return "Entry does not exist";
        }
    }

}
