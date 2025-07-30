package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mock")
public class MockTimeService implements TimeService {
    
    @Override
    public String getCurrentTime() {
        return "2023-12-01 12:00:00 (Mock Time)";
    }
} 