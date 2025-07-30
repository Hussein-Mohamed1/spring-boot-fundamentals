# Spring Boot Fundamentals

This project demonstrates core Spring Boot concepts through incremental exercises, from plain Java dependency injection to a full Spring Boot application.

## Project Structure

```
SpringBootFundamentals/
├── di/                           # Requirement 1: Plain Java DI
│   ├── src/main/java/di/
│   │   ├── Printer.java
│   │   ├── UserService.java
│   │   └── Main.java
│   └── pom.xml
├── spring-core-demo/             # Requirement 2: Spring Core
│   ├── src/main/java/com/example/
│   │   ├── Printer.java
│   │   ├── UserService.java
│   │   └── Main.java
│   └── pom.xml
├── springboot-fundamentals/      # Requirements 3-8: Spring Boot App
│   ├── src/main/java/com/example/
│   │   ├── SpringbootFundamentalsApplication.java
│   │   ├── GreetingController.java
│   │   ├── StartupListener.java
│   │   ├── LifecycleBean.java
│   │   ├── ContextInspector.java
│   │   ├── AppProperties.java
│   │   ├── TitleController.java
│   │   ├── TimeService.java
│   │   ├── SystemTimeService.java
│   │   ├── MockTimeService.java
│   │   └── TimeController.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   └── application-dev.yml
│   └── pom.xml
└── docs/                         # Documentation
    ├── annotations.md
    ├── lifecycle.log
    └── beans.txt
```

## Requirements Implemented

### 1. DIY IoC & DI in Plain Java

- **Location**: `di/` folder
- **Files**: `Printer.java`, `UserService.java`, `Main.java`
- **Demonstrates**: Constructor and setter injection without Spring
- **Run**: `cd di && mvn compile exec:java`

### 2. Introduce Spring Framework

- **Location**: `spring-core-demo/` folder
- **Files**: Spring Core dependency, `@Component` annotations, `AnnotationConfigApplicationContext`
- **Demonstrates**: Basic Spring IoC container usage
- **Run**: `cd spring-core-demo && mvn compile exec:java -Dexec.mainClass="com.example.Main"`

### 3. Bootstrap Spring Boot & "Hello" Endpoint

- **Location**: `springboot-fundamentals/` folder
- **Files**: `GreetingController.java`, Spring Boot Web starter
- **Demonstrates**: Basic Spring Boot web application
- **Run**: `cd springboot-fundamentals && mvn spring-boot:run`
- **Test**: `curl http://localhost:8082/hello`

### 4. Explore Application Lifecycle via Code

- **Files**: `StartupListener.java`, `LifecycleBean.java`
- **Demonstrates**: Application events and lifecycle management
- **Features**: `ApplicationReadyEvent` listener and `SmartLifecycle` implementation

### 5. Inspect Spring Context & Bean Container Programmatically

- **Files**: `ContextInspector.java`
- **Demonstrates**: Programmatic access to Spring context and bean inspection
- **Features**: Lists all beans and counts Spring Framework beans

### 6. Deep Dive into @SpringBootApplication

- **Files**: `SpringbootFundamentalsApplication.java`, `docs/annotations.md`
- **Demonstrates**: `@SpringBootApplication` composition and exclusions
- **Features**: Excludes `DataSourceAutoConfiguration` to prevent database auto-configuration

### 7. Configuration Files & Profiles via Code

- **Files**: `application.properties`, `application-dev.yml`, `AppProperties.java`, `TitleController.java`
- **Demonstrates**: Configuration properties binding and profile-specific configuration
- **Test**: `curl http://localhost:8082/title`

### 8. Dependency Injection Basics in Spring Boot

- **Files**: `TimeService.java`, `SystemTimeService.java`, `MockTimeService.java`, `TimeController.java`
- **Demonstrates**: Interface-based DI with `@Primary` and `@Qualifier`
- **Test**:
  - `curl http://localhost:8082/time` (uses `@Primary`)
  - `curl http://localhost:8082/time/mock` (uses `@Qualifier("mock")`)

## Running the Application

### Prerequisites

- Java 17
- Maven 3.6+

### Quick Start

1. **Plain Java DI**: `cd di && mvn compile exec:java`
2. **Spring Core**: `cd spring-core-demo && mvn compile exec:java -Dexec.mainClass="com.example.Main"`
3. **Spring Boot**: `cd springboot-fundamentals && mvn spring-boot:run`

### Testing Endpoints

1. **Start the Spring Boot application**:

   ```bash
   cd springboot-fundamentals && mvn spring-boot:run
   ```

2. **Run the automated test script**:
   ```bash
   ./test-features.sh
   ```

Or test endpoints manually:

```bash
# Basic hello endpoint
curl http://localhost:8082/hello

# Configuration properties endpoint
curl http://localhost:8082/title

# Time service endpoints
curl http://localhost:8082/time
curl http://localhost:8082/time/mock
```

## Key Concepts Demonstrated

1. **Dependency Injection**: From manual wiring to Spring-managed beans
2. **Spring Context**: Application context lifecycle and bean management
3. **Spring Boot Auto-configuration**: How Spring Boot automatically configures components
4. **Configuration Management**: Properties files, YAML, and profile-specific configuration
5. **Bean Lifecycle**: Application events and lifecycle callbacks
6. **Qualifiers and Primary**: Resolving multiple implementations of the same interface

## Documentation

- `docs/annotations.md`: Explanation of `@SpringBootApplication` composition
- `docs/lifecycle.log`: Application lifecycle logs (captured during runtime)
- `docs/beans.txt`: Bean inspection output (captured during runtime)

## Notes

- The Spring Boot application excludes `DataSourceAutoConfiguration` to prevent database auto-configuration
- All examples use constructor injection where possible, following Spring best practices
- The project demonstrates both annotation-based and programmatic configuration approaches
