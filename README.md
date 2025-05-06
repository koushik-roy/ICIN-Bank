# 🏦 ICIN Banking Application

This is a full-stack banking application built with **Spring Boot**, **Thymeleaf**, **Spring Security**, **Spring Data JPA**, and **MySQL**. It includes secure user authentication, account operations like deposit and withdrawal, and administrative functionalities like user management.

## ✨ Features

### 🛡️ Security
- **User Authentication** using Spring Security
- Role-based access control using `GrantedAuthority`
- Password encryption with BCrypt
- Login/logout support with session management

### 💰 Banking Services
- Deposit and withdraw money from an account
- View account balance and transaction history (if implemented)
- Input validation to prevent invalid transactions

### 👥 User Management
- Find users by ID or username
- Delete users (admin only)
- User registration and secure storage in the database

### 🖥️ Tech Stack

| Layer         | Technology             |
|---------------|------------------------|
| Backend       | Spring Boot            |
| Web Layer     | Spring MVC + Thymeleaf |
| Database      | MySQL + JPA/Hibernate  |
| Security      | Spring Security        |
| Testing       | JUnit 5                |



