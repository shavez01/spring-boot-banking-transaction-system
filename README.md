# 👨‍💻 Author

**Shavez Mohammad**  
Senior Technical Consultant  
Java • Spring Boot • Banking Transaction System

# 🏦 Spring Boot Banking Transaction System

A production-style Banking Transaction System built using Java 21, Spring Boot 3, and Maven.
This project demonstrates clean layered architecture, transactional integrity (ACID compliance), and RESTful API development suitable for financial systems.

## 🧠 Key Features

✔ Create Bank Accounts
✔ Deposit Money
✔ Withdraw Money
✔ Automatic Transaction Logging
✔ ACID Transaction Management (@Transactional)
✔ RESTful API Design
✔ Swagger API Documentation
✔ Clean Layered Architecture (Controller → Service → Repository)

## ⚙️ How to Run the Project

### 1️⃣ Clone Repository
```bash
git clone https://github.com/shavez01/spring-boot-banking-transaction-system.git
```

### 2️⃣ Open in Eclipse (2025)

- File → Import
- Maven → Existing Maven Project
- Select extracted folder

### 3️⃣ Run Application

- Right click → Run As → Spring Boot App
- Server runs at: http://localhost:8080


## 📖 API Documentation

### Swagger UI:
http://localhost:8080/swagger-ui.html

### 🗄️ H2 Database Console
http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:bankdb

## 🔌 API Endpoints

### 🏦 Create Account
- POST /api/accounts

Request Body:

{
  "accountHolderName": "John Doe",
  "accountNumber": "ACC1001"
}

### 💰 Deposit Money
- POST /api/accounts/{accountNumber}/deposit?amount=500

### 💸 Withdraw Money
- POST /api/accounts/{accountNumber}/withdraw?amount=200