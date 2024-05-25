# Exam Portal Documentation

## Overview
This document provides an overview of the Exam Portal application, which is built using Spring Boot, REST API, JWT authentication, and Spring Security.

## Features
- User authentication using JWT tokens
- Role-based access control
- RESTful API for exam management
- Secure endpoints using Spring Security

## Technologies Used
- Spring Boot
- REST API
- JWT Authentication
- Spring Security

## Setup Instructions
1. Clone the repository from [GitHub](https://github.com/your-repo)
2. Configure the `application.properties` file with the necessary database and security settings
3. Build and run the application using Maven or your preferred IDE

## API Endpoints
- `/api/exams` - **GET**: Retrieve all exams
- `/api/exams/{id}` - **GET**: Retrieve a specific exam by ID
- `/api/exams` - **POST**: Create a new exam
- `/api/exams/{id}` - **PUT**: Update an existing exam
- `/api/exams/{id}` - **DELETE**: Delete an exam

## Security
- JWT authentication is used for user authentication
- Spring Security is implemented to secure the endpoints and enforce role-based access control

## Conclusion
The Exam Portal application provides a secure and efficient platform for managing exams using modern technologies such as Spring Boot, REST API, JWT authentication, and Spring Security.
