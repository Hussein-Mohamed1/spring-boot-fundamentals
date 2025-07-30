package com.yourorg.library.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "library")
public class LibraryConfig {
    
    private String name;
    private String mode;
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    @Override
    public String toString() {
        return "LibraryConfig{" +
                "name='" + name + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
} 