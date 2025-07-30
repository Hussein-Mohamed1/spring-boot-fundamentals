package com.yourorg.library.service;

import org.springframework.stereotype.Service;

@Service
public class ExcludedService {
    
    public String getMessage() {
        return "This service should be excluded by component scanning";
    }
} 