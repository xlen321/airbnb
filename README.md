# 🏠 Airbnb Clone Backend API

A scalable and production-ready **Airbnb Clone Backend API** built with **Spring Boot**, **Spring Security**, **JWT Authentication**, and **PostgreSQL**. This project replicates the core functionality of Airbnb, enabling users to list properties, search accommodations, manage bookings, leave reviews, and maintain wishlists through secure RESTful APIs.

> **Project Status:** 🚧 Active Development

---

## 📖 Overview

The goal of this project is to build a modern, secure, and scalable backend inspired by Airbnb using industry best practices and clean architecture.

The application follows a layered architecture with clear separation of concerns, making it easy to maintain, extend, and test.

---

# ✨ Features

## 🔐 Authentication & Authorization

- User Registration
- User Login
- JWT Authentication
- Refresh Token Authentication
- Role-Based Access Control (RBAC)
- Password Encryption (BCrypt)
- Spring Security Integration

### Roles

- Guest
- Host
- Admin

---

## 👤 User Management

- User Profile
- Update Profile
- Change Password
- Profile Picture *(Planned)*

---

## 🏡 Property Management

- Create Property Listings
- Update Property Details
- Delete Property
- Property Images
- Amenities
- Address & Location
- Pricing Information
- Availability Management

---

## 🔍 Property Search

- Search by Location
- Search by Price
- Search by Guests
- Search by Bedrooms
- Search by Amenities
- Sorting & Filtering *(Planned)*

---

## 📅 Booking Management

- Book a Property
- Cancel Booking
- Booking Status
- Prevent Double Bookings
- Booking History

---

## ⭐ Reviews & Ratings

- Add Reviews
- Edit Reviews
- Delete Reviews
- Property Ratings
- Host Ratings

---

## ❤️ Wishlist

- Create Wishlist
- Add Property to Wishlist
- Remove Property
- Multiple Wishlists

---

## 💳 Payments *(Planned)*

- Payment Integration
- Payment History
- Refund Support

---

## 🔔 Notifications *(Planned)*

- Booking Confirmation
- Booking Cancellation
- Email Notifications

---

## 🛠️ Admin Features *(Planned)*

- User Management
- Property Moderation
- Booking Management
- Dashboard & Reports

---

# 🏗️ Tech Stack

## Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL
- JWT
- Lombok
- Maven

## Documentation

- Swagger / OpenAPI

## Testing

- JUnit 5
- Mockito

---

# 📁 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.app.airbnb
│   │       ├── audit
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── enums
│   │       ├── exception
│   │       ├── mapper
│   │       ├── repository
│   │       ├── security
│   │       ├── service
│   │       └── util
│   │
│   └── resources
│       └── application.properties
│
└── test
```

---

# 🗄️ Database Entities

- User
- Role
- Property
- Address
- Amenity
- PropertyImage
- Booking
- Availability
- Review
- Wishlist
- WishlistItem
- Payment
- RefreshToken

---

# 🛡️ Security

- JWT Authentication
- Stateless Authentication
- Spring Security
- BCrypt Password Encoding
- Role-Based Authorization
- Method-Level Security
- Refresh Token Support

---

# 📦 Prerequisites

Before running the project, make sure you have:

- Java 21+
- Maven 3.9+
- PostgreSQL 15+
- Git

---

# ⚙️ Getting Started

## 1. Clone the Repository

```bash
git clone https://github.com/your-username/airbnb-clone-backend.git

cd airbnb-clone-backend
```

---

## 2. Create the Database

```sql
CREATE DATABASE airbnb_db;
```

---

## 3. Configure Database

Update your `application.yml` or `application.properties`.

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/airbnb_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

---

## 4. Build the Project

```bash
mvn clean install
```

---

## 5. Run the Application

```bash
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

# 📚 API Documentation

Once the application is running:

### Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

### OpenAPI JSON

```
http://localhost:8080/v3/api-docs
```

---

# 🏛️ Application Architecture

```
                Client
                   │
                   ▼
            REST Controllers
                   │
                   ▼
              Service Layer
                   │
                   ▼
           Repository Layer
                   │
                   ▼
             PostgreSQL Database
```

---

# 🔐 Authentication Flow

```
User Login
     │
     ▼
Spring Security
     │
     ▼
Authentication Manager
     │
     ▼
Generate JWT Token
     │
     ▼
Client Stores JWT
     │
     ▼
Authorization Header
(Bearer <token>)
     │
     ▼
JWT Filter
     │
     ▼
Protected APIs
```

---

# 🚀 Development Roadmap

## Phase 1 – Foundation

- [x] Spring Boot Setup
- [x] PostgreSQL Configuration
- [x] User Entity
- [x] Role Entity
- [x] Auditing
- [x] JWT Authentication
- [x] Spring Security

---

## Phase 2 – User Module

- [ ] User APIs
- [ ] User Profile
- [ ] Update Profile

---

## Phase 3 – Property Module

- [ ] Property CRUD
- [ ] Property Images
- [ ] Amenities
- [ ] Address
- [ ] Availability

---

## Phase 4 – Booking Module

- [ ] Booking APIs
- [ ] Availability Validation
- [ ] Booking History

---

## Phase 5 – Review & Wishlist

- [ ] Reviews
- [ ] Ratings
- [ ] Wishlist
- [ ] Search APIs

---

## Phase 6 – Advanced Features

- [ ] Payments
- [ ] Email Notifications
- [ ] Admin Dashboard
- [ ] OAuth2 Login
- [ ] Redis Caching
- [ ] Elasticsearch
- [ ] CI/CD Pipeline
- [ ] AWS Deployment

---

# 🤝 Contributing

Contributions are welcome!

1. Fork the repository.
2. Create a new feature branch.
3. Commit your changes.
4. Push the branch.
5. Open a Pull Request.

---

# 📄 License

This project is developed for educational purposes and portfolio demonstration. It is **not affiliated with, endorsed by, or associated with Airbnb, Inc.**

---

# 👨‍💻 Author

**Aniket Chatterjee**


## ⭐ Support

If you find this project helpful, consider giving it a ⭐ on GitHub.
