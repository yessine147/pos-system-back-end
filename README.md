# POS System Backend

## Overview
This project implements the backend for a Point of Sale (POS) system using Java and Spring Boot. It provides RESTful APIs to manage orders and articles within a store.

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL (or your preferred database)

## Project Structure
The backend is structured as follows:

- **com.example.possystem.controller**: Contains REST controllers for handling HTTP requests.
- **com.example.possystem.model**: Defines JPA entities such as Article, Order, and enums like Category.
- **com.example.possystem.repository**: Interfaces for interacting with the database using Spring Data JPA.
- **com.example.possystem.service**: Service layer containing business logic for handling orders and articles.
- **com.example.possystem.Application**: Main Spring Boot application class.

## Setup Instructions
1. Clone the repository.
2. Open the project in your preferred IDE (like IntelliJ IDEA or Eclipse).
3. Set up your PostgreSQL database and configure the `application.properties` file with your database credentials.
4. Run the Spring Boot application (`PossystemApplication.java`).

## API Endpoints
- **GET /orders**: Retrieves all orders.
- **GET /orders/{id}**: Retrieves an order by ID.
- **POST /orders**: Creates a new order.
- **GET /article**: Retrieves all articles.
- **GET /article/{id}**: Retrieves an article by ID.
- **GET /article/category**: Retrieves articles by category.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
