package com.rishabh.exchangeRate.services;

import com.rishabh.exchangeRate.dto.ApiCallHandler;
import com.rishabh.exchangeRate.models.ExchangeRate;
import com.rishabh.exchangeRate.repository.RateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class SchedulerService {
    @Autowired
    private RateRepository rateRepository;
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SchedulerService.class);
    @Scheduled(fixedRate = 3600000)
    public void fetchRateData() {

        int daysToBeFetched = 4;  //366
        int dayNumberFromToday = 0;
        LocalDate today = LocalDate.now();
        String baseUrl = "https://v6.exchangerate-api.com/v6/b8caa451769b1f92aaf9f3b5/history/USD/";
        while(dayNumberFromToday <= daysToBeFetched) {
            LocalDate date = today.minusDays(dayNumberFromToday);
            dayNumberFromToday++;
            String dateString = date.toString().replace('-','/');
            if(rateRepository.findByDate(date.toString()) == null) {
                ApiCallHandler data = restTemplate.getForObject(baseUrl + dateString, ApiCallHandler.class);
                logger.warn(data.getResult());
                if(data.getResult().equals("success")) {
                    ExchangeRate exchangeRate = new ExchangeRate();
                    exchangeRate.setDate(date.toString());
                    exchangeRate.setCurrencies(data.getConversion_rates());
                    rateRepository.save(exchangeRate);
                }
            }
        }
    }

}
