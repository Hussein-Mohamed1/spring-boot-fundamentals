# @SpringBootApplication Annotation Composition

The `@SpringBootApplication` annotation is a convenience annotation that adds all of the following:

1. **@Configuration**: Tags the class as a source of bean definitions for the application context
2. **@EnableAutoConfiguration**: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings
3. **@ComponentScan**: Tells Spring to look for other components, configurations, and services in the `com/example` package, allowing it to find the controllers

## Exclusion Example

In our application, we excluded `DataSourceAutoConfiguration.class` to prevent Spring Boot from auto-configuring a DataSource, which means:

- No H2 database will be automatically started
- No database connection pool will be created
- No JPA/Hibernate auto-configuration will occur

This is useful when you don't need database functionality in your application.
