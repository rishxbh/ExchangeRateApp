package com.rishabh.exchangeRate.services;

import com.rishabh.exchangeRate.dto.DefaultResponse;
import com.rishabh.exchangeRate.models.ExchangeRate;
import com.rishabh.exchangeRate.repository.RateRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class RateServiceImplTest {

    @Mock
    private RateRepository rateRepository;

    @InjectMocks
    private RateServiceImpl rateService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getTodayDiff_Success() {
        // Mocking repository response
        HashMap<String, Double> m = new HashMap<>();
        m.put("INR", 60.0);
        LocalDate date = LocalDate.now();
        ExchangeRate todayExchangeRate = new ExchangeRate(date.toString(), m);
        when(rateRepository.findByDate(anyString())).thenReturn(todayExchangeRate);
        // Calling service method
        DefaultResponse response = rateService.getTodayDiff("INR");

        // Verifying repository method is called and returned response
        verify(rateRepository, times(8)).findByDate(anyString());
        assertNotNull(response);
        // Add more assertions as per your requirements
    }

//    @Test
//    void postData_Success() {
//        // Mocking repository response
//        when(rateRepository.findByDate("2023-01-01")).thenReturn(null);
//
//        // Calling service method
//        InsertionRequest request = new InsertionRequest("2023-01-01", new HashMap<>());
//        ExchangeRate result = rateService.postData(request);
//
//        // Verifying repository method is called and returned response
//        verify(rateRepository, times(1)).findByDate("2023-01-01");
//        verify(rateRepository, times(1)).save(any());
//        assertNotNull(result);
//        // Add more assertions as per your requirements
//    }

    // Add similar tests for putData, deleteData, and other scenarios...
}

