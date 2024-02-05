package com.rishabh.exchangeRate.services;

import com.rishabh.exchangeRate.dto.ApiCallHandler;

import com.rishabh.exchangeRate.repository.RateRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class SchedulerServiceTest {

    @Mock
    private RateRepository rateRepository;
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private SchedulerService schedulerService;

    @Test
    void fetchRateData_Success() {
        // Mocking repository response
        when(rateRepository.findByDate(anyString())).thenReturn(null);

        // Mocking restTemplate response
        ApiCallHandler apiCallHandler = new ApiCallHandler();
        apiCallHandler.setResult("success");
        apiCallHandler.setConversion_rates(null);
        when(restTemplate.getForObject(anyString(), eq(ApiCallHandler.class))).thenReturn(apiCallHandler);

        // Calling service method
        schedulerService.fetchRateData();

        // Verifying repository method is called
        verify(rateRepository, atLeastOnce()).findByDate(anyString());
        verify(rateRepository, times(367)).save(any());
    }

    @Test
    void fetchRateData_Error() {
        // Mocking repository response
        when(rateRepository.findByDate(anyString())).thenReturn(null);

        // Mocking restTemplate response
        ApiCallHandler apiCallHandler = new ApiCallHandler();
        apiCallHandler.setResult("error");
        apiCallHandler.setConversion_rates(null);
        when(restTemplate.getForObject(anyString(), eq(ApiCallHandler.class))).thenReturn(apiCallHandler);

        // Calling service method
        schedulerService.fetchRateData();

        // Verifying repository method is called
        verify(rateRepository, atLeastOnce()).findByDate(anyString());
        verify(rateRepository, times(0)).save(any());
    }
}
