package com.rishabh.exchangeRate.controller;

import com.rishabh.exchangeRate.dto.DefaultResponse;
import com.rishabh.exchangeRate.services.RateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class RateControllerTest {
    @Mock
    private RateService rateService;

    @InjectMocks
    private RateController rateController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getDifference_Success() {
        // Mocking service response
        DefaultResponse response = new DefaultResponse("Entry does not exist","Entry does not exist",
                "Entry does not exist","Entry does not exist","Entry does not exist",
                "Entry does not exist","Entry does not exist");
        when(rateService.getTodayDiff("INR")).thenReturn(response);
        // Calling controller method
        ResponseEntity<DefaultResponse> result = rateController.getDifference("INR");

        // Verifying service method is called and returned response
        verify(rateService, times(1)).getTodayDiff("INR");
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }

    @Test
    void getDifference_NoData() {
        // Mocking service response
        when(rateService.getTodayDiff("INR")).thenReturn(null);

        // Calling controller method
        ResponseEntity<DefaultResponse> result = rateController.getDifference("INR");

        // Verifying service method is called and returned response
        verify(rateService, times(1)).getTodayDiff("INR");
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNull(result.getBody());
    }
}
