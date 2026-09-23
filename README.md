# Employee Management System (EMS)

Employee Management System (EMS) is a **Spring Boot REST API project** developed to manage employee information, employee details, and salary information efficiently.

The project uses **three separate entities — Employee, EmployeeDetails, and EmployeeSalary — with One-to-One relationships**. The `emp_id` is the primary key in the Employee entity and is used as a foreign key in the related EmployeeDetails and EmployeeSalary tables.

## 🚀 Features

* Employee CRUD operations
* Employee Details CRUD operations
* Employee Salary CRUD operations
* Employee Login API
* Active and Inactive Employee Dashboard
* Top 10 Highest Salary Employees API
* One-to-One entity relationships
* Primary Key and Foreign Key relationships
* Input validation
* Exception handling
* Custom SQL/Native Queries
* RESTful API architecture
* API testing using Postman

## 🏗️ Project Structure

```text
Employee
   |
   |--- One-to-One ---> EmployeeDetails
   |
   |--- One-to-One ---> EmployeeSalary
```

### Database Relationship

```text
Employee
-----------------
emp_id (PK)
ename
email
phoneno
department
status
password
       |
       | 1 : 1
       |
       +---------------- EmployeeDetails
       |                 -----------------
       |                 emp_id (FK)
       |                 address
       |                 pan
       |                 gender
       |
       |
       +---------------- EmployeeSalary
                         ----------------
                         emp_id (FK)
                         salary
                         basicSalary
                         bonus
```

## 📊 Dashboard

The dashboard API provides employee statistics such as:

* Total Employees
* Active Employees
* Inactive Employees

Example:

```text
Total Employees  : 50
Active Employees : 42
Inactive Employees: 8
```

## 💰 Top 10 Salary API

The project includes an API to retrieve the **top 10 employees based on salary**.

Example:

```text
GET /api/employees/top10salary
```

The API returns employee information along with their salary details.

## 🔐 Login API

The login API allows employees to authenticate using their registered **email or phone number and password**.

Example:

```text
POST /api/employees/login
```

## 🔄 CRUD Operations

The application provides separate APIs for:

### Employee

* Create Employee
* Get Employee
* Get All Employees
* Update Employee
* Delete Employee

### EmployeeDetails

* Create Details
* Get Details
* Update Details
* Delete Details

### EmployeeSalary

* Create Salary
* Get Salary
* Update Salary
* Delete Salary

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **REST API**
* **Maven**
* **Postman**

## 🧩 Architecture

The application follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Layers

**Controller:** Handles HTTP requests and API endpoints.

**Service:** Contains business logic and validation.

**Repository:** Performs database operations using Spring Data JPA and custom queries.

**Entity:** Represents database tables and their relationships.

**DTO:** Handles request and response data between the client and application.

## 📌 Key Learning

This project demonstrates practical implementation of:

* Spring Boot REST APIs
* CRUD operations
* Spring Data JPA
* Hibernate
* One-to-One relationships
* Primary Key and Foreign Key mapping
* JPQL and Native SQL queries
* DTO implementation
* Validation
* Exception handling
* Business logic implementation
* MySQL database integration
* API testing with Postman

## 👨‍💻 Author

**Amit Gupta**

Java Developer | Spring Boot | REST API | MySQL
