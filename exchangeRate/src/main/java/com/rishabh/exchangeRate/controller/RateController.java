package com.rishabh.exchangeRate.controller;

import com.rishabh.exchangeRate.dto.DefaultResponse;
import com.rishabh.exchangeRate.dto.InsertionRequest;
import com.rishabh.exchangeRate.models.ExchangeRate;
import com.rishabh.exchangeRate.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchangeRate")
public class RateController {
    @Autowired
    private RateService rateService;
    @GetMapping("/diff/{curr}")
    public ResponseEntity<DefaultResponse> getDifference(@PathVariable("curr") String currency) {
        DefaultResponse response = rateService.getTodayDiff(currency.toUpperCase());
        if(response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<ExchangeRate> postData(@RequestBody InsertionRequest request) {
        ExchangeRate exchangeRate = rateService.postData(request);
        if(exchangeRate == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(exchangeRate);
        }
    }

    @PutMapping("/put")
    public ResponseEntity<ExchangeRate> putData(@RequestBody InsertionRequest request) {
        ExchangeRate exchangeRate = rateService.putData(request);
        if(exchangeRate == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(exchangeRate);
        }
    }

    @DeleteMapping("/delete/{date}")
    public ResponseEntity<String> deleteData(@PathVariable("date") String date) {
        String result = rateService.deleteData(date);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
