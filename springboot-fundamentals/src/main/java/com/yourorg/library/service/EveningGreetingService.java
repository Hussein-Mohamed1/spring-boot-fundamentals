package com.yourorg.library.service;

import org.springframework.stereotype.Service;

@Service("eveningGreetingService")
public class EveningGreetingService implements GreetingService {
    
    @Override
    public String getGreeting() {
        return "Good Evening!";
    }
} 