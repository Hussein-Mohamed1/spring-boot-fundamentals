package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitleController {
    
    @Autowired
    private AppProperties appProperties;
    
    @GetMapping("/title")
    public String getTitle() {
        return appProperties.getTitle();
    }
} 