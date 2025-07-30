package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ContextInspector implements CommandLineRunner {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Spring Context Bean Inspection ===");
        
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        
        System.out.println("Total beans found: " + beanNames.length);
        System.out.println("\nAll bean names:");
        for (String beanName : beanNames) {
            System.out.println("- " + beanName);
        }
        
        long springFrameworkBeans = Arrays.stream(beanNames)
                .filter(name -> name.startsWith("org.springframework"))
                .count();
        
        System.out.println("\nBeans starting with 'org.springframework': " + springFrameworkBeans);
        
        System.out.println("=== End of Bean Inspection ===\n");
    }
} 