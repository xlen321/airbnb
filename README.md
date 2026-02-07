# 🏡 Airbnb Clone (Backend)

A scalable backend system inspired by Airbnb, built using **Spring Boot**, **JPA/Hibernate**, and **PostgreSQL**.

This project focuses on **clean domain modeling**, **explicit lifecycle management**, and **correct booking foundations**, reflecting how real-world hospitality platforms are designed.

The backend is built incrementally with an emphasis on:

* correctness over shortcuts
* explicit lifecycle & availability modeling
* long-term maintainability and extensibility

---

## 🎯 Project Vision

The goal of this project is to model the **core backend foundations** of a short-term rental platform, including:

* Property listings and metadata
* Unit-based inventory modeling
* Reusable amenities and media assets
* Date-based availability and pricing
* Explicit lifecycle and verification control
* Safe booking and payment workflows

Design decisions prioritize **clarity, correctness, and real-world constraints** over minimal or tutorial-style implementations.

---

## ✨ Key Capabilities

* 🏠 Property listing & verification lifecycle
* 🛏 Unit-based inventory (rooms / apartments / identical units)
* 📍 Embedded address, location, and contact information
* 🏷 Reusable amenity catalog (property & unit level)
* 🖼 Property- and unit-level photo management
* 📅 Per-day availability with date-specific pricing
* 🔒 Booking-safe availability modeling (no double booking)
* 💳 Payment modeling with retries & refunds
* 💬 Booking-scoped reviews for trust & authenticity

---

## 🧠 Core Design Principles

* Separate **lifecycle state** from **availability state**
* Model availability explicitly per date
* Normalize transactional data for correctness
* Embed value objects where appropriate
* Avoid premature optimization
* Favor explicit workflows over hidden behavior

---

## 🛠 Technology Stack

* **Java 25 (LTS)**
* Spring Boot
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven

---

## 📁 Project Structure (Feature-Based)

```
com.example.airbnb
├── auth
├── user
├── property
├── unit
├── availability
├── booking
├── guest
├── review
├── payment
├── amenity
├── common
│   ├── exception
│   ├── util
│   └── security
└── config
```

Each feature owns:

* its entities
* enums
* repositories
* services

Cross-cutting concerns live in `common`.

---

## 🔁 Lifecycle vs Availability

A **strict distinction** is maintained between lifecycle state and booking availability.

### Lifecycle (entity-level)

Lifecycle controls whether an entity participates in the system.

Examples:

* Property verification status (DRAFT → VERIFIED → REJECTED)
* Listing status (PUBLISHED / UNLISTED)
* Soft deletion via `deletedAt`

Lifecycle state **does not represent bookings**.

---

### Availability (date-based)

Availability controls whether a **unit** can be booked on a specific date.

Availability is modeled **per unit per date**, supporting:

* safe concurrent booking
* date-specific pricing
* blocked or closed dates

Availability is the **single source of truth** for booking safety.

---

## 📅 Availability Model Overview

Availability is modeled **per calendar day**, not as date ranges.

Each availability record answers:

* Is this unit bookable on this date?
* How many units are available?
* Is the date closed?
* Is pricing overridden?

This design:

* prevents double bookings
* supports surge pricing
* scales to hotels & homes

---

## 🔌 API & DTO Design

The system strictly separates **external API contracts** from **internal domain workflows**.

### API DTOs

* Define client-visible contracts
* Validated at the API boundary
* Stable and backward-compatible

### Internal DTOs

* Used for service-to-service communication
* Represent intent-based operations
* Allow safe evolution of domain logic

---

## 🛑 Error Handling & API Contracts

Business rules are enforced using **domain exceptions** inside services.

Exceptions express **what went wrong**, not how errors are exposed.

A centralized global exception handler:

* maps domain errors to HTTP responses
* ensures consistent error format
* keeps controllers free of business logic

### Standard Error Response

```json
{
  "code": "BOOKING_NOT_ALLOWED",
  "message": "Guest cannot be removed within 24 hours of check-in",
  "timestamp": "2025-12-20T10:15:00Z"
}
```

---

## 📊 Project Progress

### ✅ Completed

* Core domain modeling (Property, Unit, Booking, User)
* Unit-based inventory & availability design
* Explicit lifecycle & verification modeling
* Amenity catalog & media assets
* Booking-safe availability model
* Guest modeling (booking-scoped)
* Review model (booking-verified reviews)
* Payment model (retry & refund ready)
* Domain exception framework
* Feature-based package structure

### 🚧 In Progress

* Booking transaction workflow
* Availability locking & validation
* Booking status transitions
* Payment → booking confirmation integration

### 🗺 Planned

* Cancellation & refund workflows
* Availability caching
* Search & filtering
* Event-driven updates
* Authentication & authorization (final phase)
* Frontend integration

---

## 🔐 Authentication Strategy

Authentication and authorization are **intentionally implemented last**, after core domain logic stabilizes.

This avoids premature coupling and allows:

* stable API design
* cleaner role enforcement
* safer security integration

---

## 🚀 Getting Started

### Prerequisites

* Java 21
* Maven
* PostgreSQL

### Run Locally

```bash
mvn spring-boot:run
```

Environment-specific configuration is handled via `.env` and Spring profiles.

---

## 📌 Project Scope

This project focuses on:

* realistic backend design challenges
* clean ORM & schema modeling
* correctness under concurrency

UI concerns are intentionally out of scope.

---

## 📝 Notes

This README is a living document and evolves alongside the system.
