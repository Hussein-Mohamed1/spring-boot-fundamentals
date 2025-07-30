package com.yourorg.library.controller;

import com.yourorg.library.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("libraryGreetingController")
@RequestMapping("/greeting")
public class GreetingController {

    // Field injection
    @Autowired
    @Qualifier("morningGreetingService")
    private GreetingService morningService;

    // Constructor injection
    private final GreetingService eveningService;

    // Setter injection
    private GreetingService defaultService;

    public GreetingController(@Qualifier("eveningGreetingService") GreetingService eveningService) {
        this.eveningService = eveningService;
    }

    @Autowired
    public void setDefaultService(@Qualifier("morningGreetingService") GreetingService defaultService) {
        this.defaultService = defaultService;
    }

    @GetMapping("/morning")
    public String getMorningGreeting() {
        return morningService.getGreeting();
    }

    @GetMapping("/evening")
    public String getEveningGreeting() {
        return eveningService.getGreeting();
    }

    @GetMapping("/default")
    public String getDefaultGreeting() {
        return defaultService.getGreeting();
    }
} 