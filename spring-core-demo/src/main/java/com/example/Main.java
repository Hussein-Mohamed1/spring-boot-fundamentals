package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        
        UserService userService = context.getBean(UserService.class);
        userService.processUser("Spring User");
        
        Printer printer = context.getBean(Printer.class);
        printer.print("Direct printer call");
        
        context.close();
    }
} 