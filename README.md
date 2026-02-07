# 🏡 Airbnb Clone

A scalable backend system inspired by Airbnb, built using **Spring Boot**, **JPA/Hibernate**, and **PostgreSQL**.  
This project focuses on clean domain modeling, explicit lifecycle management, and reliable booking foundations, reflecting how real-world hospitality platforms are designed.

The backend is being built incrementally with an emphasis on:
- correctness over shortcuts
- clear separation of lifecycle and availability
- long-term maintainability and extensibility

---

## 🎯 Project Vision

The goal of this project is to model the core backend foundations of a short-term rental platform, including:

- Property listings and metadata
- Room-based inventory units
- Reusable amenities and media assets
- Date-based availability and pricing
- Clear lifecycle control of listings and rooms

Design decisions prioritize clarity, consistency, and real-world constraints over minimal implementations.

---

## ✨ Key Capabilities

- 🏨 Property (Hotel) management  
- 🛏 Room-based inventory modeling  
- 📍 Embedded address, location, and contact information  
- 🏷 Reusable amenity catalog  
- 🖼 Listing- and room-level photo management  
- 📅 Per-day availability with date-specific pricing  
- 🔁 Explicit lifecycle control using `isActive` flags  

---

## 🧠 Design Principles

- Normalize transactional data to ensure correctness  
- Separate **lifecycle state** from **availability state**  
- Embed value objects to reduce unnecessary joins  
- Model availability explicitly to prevent double bookings  
- Favor extensibility over premature optimization  

---

## 🛠 Technology Stack

- Java 25
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven

---

## 📁 Project Structure

    src/main/java/com/example/airbnb
     ├── models          # Domain & JPA entities
     ├── repositories    # Persistence layer
     ├── services        # Business logic
     ├── controllers     # REST APIs
     ├── dtos            # API & internal DTOs
     └── exceptions      # Domain exceptions & API error handling

---

## 🔁 Lifecycle vs Availability

A clear distinction is maintained between **entity lifecycle** and **booking availability**.

### Lifecycle (`isActive`)
- Controls whether an entity participates in the system
- Applies at a coarse-grained level

Examples:
- `Hotel.isActive = false` → listing is hidden and not bookable
- `Room.isActive = false` → room is removed from usable inventory

### Availability (date-based)
- Controls whether a listing or room can be booked on a specific date
- Managed through per-day availability records

Availability does not deactivate entities, and lifecycle flags do not represent bookings.

---

## 📅 Availability Model Overview

Availability is modeled **per date**, rather than as date ranges.

Each availability record answers:
- Can this be booked on this date?
- At what price?
- Is it explicitly blocked?

This design supports:
- Prevention of double bookings
- Date-specific pricing (including seasonal variation)
- Safe concurrent access

The availability calendar acts as the single source of truth for bookings.

---

## 🔌 API & DTO Design

The system clearly separates external API contracts from internal domain workflows.

## API DTOs
- API DTOs define what clients are allowed to send and receive.
- They are stable, validated, and independent of business rule enforcement.
- Examples:
    - Booking creation requests
    - Guest add/update requests
    - Read-only response models

## Internal DTOs
- Internal DTOs are used for communication between services and repositories.
- They are stable, validated, and independent of business rule enforcement.
- They represent intent-based domain operations and are used exclusively within the service layer.
- Examples:
    - Hotel read models
    - Room read models
    - Booking read models
    - User read models

- They enable:
    - Explicit business rule enforcement
    - Clear workflow orchestration
    - Safe evolution of domain logic without breaking APIs


## 🛑 Error Handling & API Contracts

The system enforces business rules using **domain exceptions** and translates them into HTTP responses at the API boundary.

### Domain Exceptions
Business rules are enforced inside the service layer using explicit domain exceptions.

These exceptions represent **what went wrong**, not how the error is exposed over HTTP.

Examples include:
- Booking not allowed due to lifecycle rules
- Guest modification restrictions (e.g. within 24 hours of check-in)
- Room availability conflicts
- Unauthorized actions on bookings

Domain exceptions are reusable across:
- REST APIs
- background jobs
- future integrations

---

### Global Exception Handling
All domain exceptions are translated into HTTP responses using a centralized global exception handler.

This ensures:
- Consistent error response format
- Clear, machine-readable error codes
- No business logic inside controllers
- Stable API behavior as rules evolve

---

### Standard Error Response

All API errors follow a uniform structure:

```json
{
  "code": "BOOKING_NOT_ALLOWED",
  "message": "Guest cannot be removed within 24 hours of check-in",
  "timestamp": "2025-12-20T10:15:00Z"
}
```


## 📊 Project Progress

### ✅ Completed
- Core domain modeling (Hotel, Room, User)
- Room-based inventory design (one room = one booking)
- Explicit lifecycle handling using `isActive`
- Embedded address, location, and contact information
- Amenity catalog modeling
- Listing- and room-level photo support
- User model with roles and authentication-ready fields
- Guest modeling (booking-scoped stay participants)
- Gender enum for guest details
- Payment schema design (booking-linked, retry/refund ready)
- API DTO and internal command separation
- Domain exception modeling with centralized error handling
- Clear separation of lifecycle vs availability concerns

### 🚧 In Progress
- Booking workflow implementation (Option 1: single-room booking)
- Availability locking and validation
- Booking status transitions (confirm / cancel)
- Payment → booking confirmation integration

### 🗺 Planned
- Cancellation and refund flows
- Availability caching 
- Search and filtering 
- Event-driven booking updates
- Frontend integration


---

## 🔮 Frontend (Planned)

A frontend application will be added in a later phase of this project.

The current focus is on building a robust and well-structured backend, ensuring:
- correct domain modeling
- explicit lifecycle management
- stable availability and booking foundations

Once the backend stabilizes, a frontend (web or mobile) will be introduced to consume the APIs.

---

## 🚀 Getting Started

### Prerequisites

- Java 25  
- Maven  
- PostgreSQL
- Spring Data JPA

### Run Locally

    git clone https://github.com/your-username/airbnb-backend.git
    cd airbnb-backend
    mvn spring-boot:run

Database configuration can be updated in `application.properties`.

---

## 📌 Project Scope

This project is intended to:
- Explore realistic backend design challenges
- Practice clean ORM and schema modeling
- Serve as a foundation for future extensions

It intentionally avoids UI concerns and focuses on backend correctness and structure.

---

## 📝 Notes

This README is treated as a living document and will evolve alongside the system as new features and architectural components are added.
