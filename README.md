# Enviro365 Investment Withdrawal System

## Overview

The Enviro365 Investment Withdrawal System is a full-stack application that enables investors to view investment portfolios, submit withdrawal requests, track withdrawal history, and export withdrawal records to CSV format.

The application was developed using Spring Boot for the backend and React for the frontend.

---

## Features

### Portfolio Dashboard
- View available investment portfolios
- Display portfolio balances
- View portfolio information

### Withdrawal Management
- Create withdrawal requests
- Validate withdrawal rules
- Update portfolio balances automatically
- Prevent invalid withdrawals

### Withdrawal History
- Track all withdrawals
- View withdrawal amounts and dates
- Display withdrawal records in a structured format

### CSV Export
- Download withdrawal history as a CSV file

---

## Business Rules

The system enforces the following rules:

- A withdrawal amount cannot exceed the available portfolio balance.
- A withdrawal amount cannot exceed 90% of the portfolio value.
- Retirement fund withdrawals are only permitted for investors older than 65 years.
- Invalid requests generate meaningful error messages.

---

## Technologies Used

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Maven
- H2 Database

### Frontend
- React
- Axios
- HTML
- CSS

### Tools
- IntelliJ IDEA
- Postman
- Git
- GitHub

---

## Project Structure

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
