# Spring Boot Fundamentals Project

This project demonstrates Spring Boot fundamentals including dependency injection, configuration management, component scanning, and JPA integration.

## Project Structure

```
src/main/java/
├── com.example/                    # Original working application
│   ├── SpringbootFundamentalsApplication.java
│   ├── GreetingController.java
│   ├── TimeController.java
│   ├── TitleController.java
│   ├── HealthController.java
│   └── ...
└── com.yourorg.library/           # New requirements implementation
    ├── config/
    │   ├── LibraryConfig.java
    │   └── ComponentScanConfig.java
    ├── controller/
    │   ├── GreetingController.java
    │   ├── NotificationController.java
    │   └── BookController.java
    ├── service/
    │   ├── GreetingService.java
    │   ├── MorningGreetingService.java
    │   ├── EveningGreetingService.java
    │   ├── NotificationService.java
    │   ├── EmailNotificationService.java
    │   ├── SmsNotificationService.java
    │   └── ExcludedService.java
    ├── repository/
    │   └── BookRepository.java
    └── model/
        └── Book.java
```

## Requirements Implementation

### 1. Core Setup & Anatomy ✅

- **Spring Boot with Web and JPA**: Added `spring-boot-starter-data-jpa` dependency
- **@SpringBootApplication**: Main class exists in `com.example.SpringbootFundamentalsApplication`
- **/health endpoint**: Created `HealthController` returning "OK"

### 2. Dependency Injection Basics ✅

- **GreetingService interface**: Created with `getGreeting()` method
- **Two implementations**: `MorningGreetingService` and `EveningGreetingService`
- **Three injection types**: Constructor, setter, and field injection in `GreetingController`

### 3. Configuration & Profiles ✅

- **Externalized properties**: `library.name` and `library.mode` in `application.properties`
- **Profile-specific files**: `application-dev.yml` and `application-prod.yml`
- **@ConfigurationProperties**: `LibraryConfig` bean binds to library properties
- **Profile activation**: Can be set via `spring.profiles.active`

### 4. Component Scanning & Stereotypes ✅

- **Package organization**: `com.yourorg.library` with subpackages
- **@ComponentScan filters**: Include services/controllers/repositories, exclude "Excluded" classes
- **Integration test**: Verifies excluded beans aren't loaded

### 5. Advanced Dependency Injection ✅

- **Two NotificationService beans**: `EmailNotificationService` (@Primary) and `SmsNotificationService` (@Qualifier)
- **NotificationController**: Exposes `/notify/email` and `/notify/sms` endpoints

### 6. Book Entity & CRUD ✅

- **Book entity**: JPA entity with id, title, author, isbn
- **BookRepository**: Extends JpaRepository with custom finder methods
- **BookController**: Full CRUD operations (Create, Read, Update, Delete)

## Running the Application

### Prerequisites

- Java 17
- Maven 3.6+

### Quick Start

```bash
cd springboot-fundamentals
mvn spring-boot:run
```

### Test All Features

After starting the application, run:

```bash
./test-features.sh
```

This will test all endpoints including original and new features.

### Manual Testing

If you prefer to test manually, here are the available endpoints:

#### Original Application (com.example)

- `GET /health` - Health check
- `GET /hello` - Hello endpoint
- `GET /time` - Current time
- `GET /time/mock` - Mock time
- `GET /title` - Application title

#### New Library Application (com.yourorg.library)

- `GET /greeting/morning` - Morning greeting (field injection)
- `GET /greeting/evening` - Evening greeting (constructor injection)
- `GET /greeting/default` - Default greeting (setter injection)
- `GET /notify/email?message=Hello` - Email notification (@Primary)
- `GET /notify/sms?message=Hello` - SMS notification (@Qualifier)
- `POST /books` - Create a book (JSON body)
- `GET /books` - Get all books
- `GET /books/{id}` - Get book by ID
- `GET /books/author/{author}` - Get books by author

### Profile Activation

#### Development Profile

```bash
mvn spring-boot:run -Dspring.profiles.active=dev
```

#### Production Profile

```bash
mvn spring-boot:run -Dspring.profiles.active=prod
```

## Testing

### Run All Tests

```bash
mvn test
```

### Integration Tests

- `ComponentScanIntegrationTest`: Verifies component scanning filters work correctly
- `GreetingControllerTest`: Tests greeting endpoints
- `TitleControllerTest`: Tests title endpoint

## Configuration Files

### application.properties

```properties
app.title=Spring Boot Fundamentals
library.name=My Library
library.mode=development
server.port=8082
```

### application-dev.yml

```yaml
app:
  title: Dev Title
library:
  name: Development Library
  mode: development
server:
  port: 8082
```

### application-prod.yml

```yaml
library:
  name: Production Library
  mode: production
server:
  port: 8080
```

## Key Features Demonstrated

1. **Dependency Injection**: Constructor, setter, and field injection
2. **Configuration Management**: Properties files, YAML, and @ConfigurationProperties
3. **Profile Management**: Environment-specific configurations
4. **Component Scanning**: Custom filters for bean discovery
5. **JPA Integration**: Entity, repository, and CRUD operations
6. **Service Stereotypes**: @Service, @Repository, @Controller
7. **Bean Qualifiers**: @Primary and @Qualifier for multiple implementations

## Database

The application uses H2 in-memory database for development. The database is automatically created when the application starts.

## Notes

- The original application in `com.example` package remains fully functional
- New requirements are implemented in `com.yourorg.library` package
- Both applications run simultaneously on the same port
- Component scanning is configured to exclude classes with "Excluded" in the name
