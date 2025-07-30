package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {
    
    private final TimeService primaryTimeService;
    private final TimeService mockTimeService;
    
    public TimeController(TimeService primaryTimeService, 
                         @Qualifier("mock") TimeService mockTimeService) {
        this.primaryTimeService = primaryTimeService;
        this.mockTimeService = mockTimeService;
    }
    
    @GetMapping("/time")
    public String getCurrentTime() {
        return "Primary: " + primaryTimeService.getCurrentTime();
    }
    
    @GetMapping("/time/mock")
    public String getMockTime() {
        return "Mock: " + mockTimeService.getCurrentTime();
    }
} 