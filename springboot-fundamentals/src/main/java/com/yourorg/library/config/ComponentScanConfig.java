package com.yourorg.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    basePackages = "com.yourorg.library",
    includeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = ".*Service|.*Controller|.*Repository"
    ),
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.REGEX,
        pattern = ".*Excluded.*"
    )
)
public class ComponentScanConfig {
    // This configuration ensures only Service, Controller, and Repository classes
    // are scanned, and any class with "Excluded" in the name is excluded
} 