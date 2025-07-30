package com.yourorg.library;

import com.yourorg.library.service.ExcludedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.profiles.active=dev"
})
public class ComponentScanIntegrationTest {

    @Test
    public void testExcludedServiceIsNotLoaded(ApplicationContext context) {
        // The ExcludedService should not be loaded due to component scanning filters
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            context.getBean(ExcludedService.class);
        });
    }

    @Test
    public void testIncludedServicesAreLoaded(ApplicationContext context) {
        // These services should be loaded
        assertNotNull(context.getBean("morningGreetingService"));
        assertNotNull(context.getBean("eveningGreetingService"));
        assertNotNull(context.getBean("emailNotificationService"));
        assertNotNull(context.getBean("smsNotificationService"));
    }
} 