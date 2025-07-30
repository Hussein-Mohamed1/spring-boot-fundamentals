package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final Printer printer;
    
    @Autowired
    public UserService(Printer printer) {
        this.printer = printer;
    }
    
    public void processUser(String username) {
        printer.print("Processing user: " + username);
    }
} 