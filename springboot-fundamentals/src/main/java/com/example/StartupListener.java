package com.example;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener implements ApplicationListener<ApplicationReadyEvent> {
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("=== Application is ready and listening for requests ===");
        System.out.println("Startup completed at: " + event.getTimestamp());
        System.out.println("Application context: " + event.getApplicationContext().getApplicationName());
    }
} 