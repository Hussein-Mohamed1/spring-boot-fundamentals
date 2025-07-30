package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example", "com.yourorg.library"})
@EnableJpaRepositories(basePackages = {"com.yourorg.library.repository"})
@EntityScan(basePackages = {"com.yourorg.library.model"})
public class SpringbootFundamentalsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootFundamentalsApplication.class, args);
    }
} 