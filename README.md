# Enviro365 Investment Withdrawal System

## Overview

The Enviro365 Investment Withdrawal System is a full-stack web application developed using Spring Boot and React.

The application allows investors to view their investment portfolios, create withdrawal requests, monitor withdrawal history, and export withdrawal records as CSV reports.

The system implements business validation rules to ensure withdrawals comply with investment product requirements and portfolio limitations.

---

# Features

## Portfolio Dashboard

- View available investment portfolios
- View portfolio balances
- Display portfolio product information
- Track portfolio value changes after withdrawals

## Withdrawal Management

- Create withdrawal requests
- Validate business rules before processing withdrawals
- Automatically update portfolio balances
- Prevent invalid withdrawal requests

## Withdrawal History

- View all completed withdrawals
- Track withdrawal amounts
- Display withdrawal dates
- Review transaction history

## CSV Export

- Export withdrawal records
- Download withdrawal history as a CSV file
- Generate reports for review and auditing purposes

---

# Business Rules

The system enforces the following rules:

- A withdrawal cannot exceed the available portfolio balance.
- A withdrawal cannot exceed 90% of the portfolio value.
- Retirement Fund withdrawals are only allowed for investors older than 65 years.
- Invalid requests generate meaningful error messages.

---

# Technologies Used

## Backend

- Java
- Spring Boot
- Spring Data JPA
- Maven
- H2 Database

## Frontend

- React
- Axios
- HTML
- CSS

## Development Tools

- IntelliJ IDEA
- Visual Studio Code
- Postman
- Git
- GitHub

---

# Project Structure

```text
enviro365-investment-withdrawal-system
│
├── src
│   ├── main
│   └── test
│
├── withdrawal-ui
│   ├── public
│   ├── src
│   ├── package.json
│   └── package-lock.json
│
├── pom.xml
└── README.md
```

---

# API Endpoints

## Investors

```http
GET /api/investors
```

Returns all investors.

---

## Portfolios

```http
GET /api/portfolios
```

Returns all investment portfolios.

---

## Withdrawals

### Get Withdrawal History

```http
GET /api/withdrawals
```

Returns a list of all withdrawals.

### Create Withdrawal

```http
POST /api/withdrawals
```

Example Request:

```json
{
  "portfolioId": 1,
  "amount": 1000
}
```

---

## CSV Export

```http
GET /api/withdrawals/export
```

Downloads withdrawal history as a CSV file.

---

# Running the Application

## Backend

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

or run:

```text
WithdrawalSystemApplication.java
```

from IntelliJ IDEA.

Backend URL:

```text
http://localhost:8080
```

---

## Frontend

Navigate to the React application:

```bash
cd withdrawal-ui
```

Install dependencies:

```bash
npm install
```

Start the application:

```bash
npm start
```

Frontend URL:

```text
http://localhost:3000
```

---

# Key Functionality Demonstrated

✅ Portfolio Dashboard

✅ Portfolio 
