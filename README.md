# Microservices Project with Spring Boot and MongoDB

## Overview

This project is a microservices-based application developed using **Spring Boot**. The system is designed with several independently deployable services, each performing a specific function. The services communicate with each other and interact with a **MongoDB** database. 

The architecture also includes **Eureka Service Discovery**, **API Gateway**, and **Circuit Breaker** for resilience and fault tolerance. Each service is registered in the Eureka server, and all external requests are routed through the **API Gateway**.

### Services Included:
- **UserService**
- **HotelService**
- **RatingService**
- **ConfigServer**
- **ApiGateway**
- **ServiceRegistry (Eureka Server)**

---

## Architecture Overview

The project is organized as follows:

1. **UserService**: Handles user-related operations.
2. **HotelService**: Manages hotel-related information.
3. **RatingService**: Deals with ratings and reviews.
4. **ConfigServer**: Provides centralized configuration management for all services.
5. **ApiGateway**: Routes requests to appropriate microservice.
6. **ServiceRegistry (Eureka Server)**: Handles the registration and discovery of all services.

---

## Features

- **Service Discovery with Eureka**: All services register with Eureka, enabling dynamic service discovery.
- **API Gateway**: A single entry point that routes requests to the appropriate microservice.
- **Circuit Breaker**: Ensures the system remains resilient by preventing cascading failures.
- **MongoDB Integration**: Each service uses MongoDB as its persistent data store.

---

## Getting Started

### Prerequisites
- JDK 11 or higher
- Maven or Gradle
- Docker (for containerized services, if needed)
- MongoDB (for database)

### Setup and Configuration

1. Clone the repository:
   ```bash
   git clone [https://github.com/your-username/your-repository.git]
