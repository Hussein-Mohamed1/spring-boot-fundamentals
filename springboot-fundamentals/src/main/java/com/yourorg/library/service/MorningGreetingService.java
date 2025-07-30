package com.yourorg.library.service;

import org.springframework.stereotype.Service;

@Service("morningGreetingService")
public class MorningGreetingService implements GreetingService {
    
    @Override
    public String getGreeting() {
        return "Good Morning!";
    }
} 