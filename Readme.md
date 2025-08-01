
# 🧑‍🎓 Student CRUD Application using Java & MySQL

This is a simple **Java-based CRUD project** that connects to a MySQL database using **JDBC**. It allows you to **Create**, **Read**, **Update**, and **Delete** student records from a `Student` table, and also includes a basic transaction example using an `Accounts` table.

---

## 🛠 Prerequisites

### 1. Install MySQL Workbench & MySQL Server

- Download and install MySQL: https://dev.mysql.com/downloads/installer/
- Create a user (e.g., root) and remember the password.
- Start the MySQL server.

### 2. Install MySQL JDBC Driver

- Download the latest **MySQL Connector/J**: https://dev.mysql.com/downloads/connector/j/
- Extract the `.zip` or `.tar.gz` file and locate the `.jar` file (e.g., `mysql-connector-java-8.x.x.jar`).

### 3. Add JDBC Driver to IntelliJ

1. Go to `File` → `Project Structure`.
2. Click on `Libraries`.
3. Click `+` → `Java`.
4. Select the downloaded `.jar` file.
5. Click OK and apply the changes.

---

## 🧱 Step-by-Step Setup

### Step 1: Create the Database

Open **MySQL Workbench** and run:

```sql
CREATE DATABASE SchoolDb;
USE SchoolDb;
```

---

### Step 2: Create `Student` Table

```sql
CREATE TABLE Student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    grade VARCHAR(10),
    email VARCHAR(100)
);
```

### Step 3: Insert Dummy Student Data

You can insert 20-30 records manually or use this script:

```sql
INSERT INTO Student (name, age, grade, email) VALUES
('Aman', 16, '10th', 'aman@example.com'),
('Riya', 17, '11th', 'riya@example.com'),
('Kunal', 15, '9th', 'kunal@example.com'),
('Sara', 18, '12th', 'sara@example.com'),
('Rahul', 16, '10th', 'rahul@example.com'),
('Pooja', 17, '11th', 'pooja@example.com'),
('Dev', 15, '9th', 'dev@example.com'),
('Nisha', 18, '12th', 'nisha@example.com'),
('Arjun', 16, '10th', 'arjun@example.com'),
('Kriti', 17, '11th', 'kriti@example.com'),
('Yash', 15, '9th', 'yash@example.com'),
('Simran', 18, '12th', 'simran@example.com'),
('Neha', 16, '10th', 'neha@example.com'),
('Kabir', 17, '11th', 'kabir@example.com'),
('Tina', 15, '9th', 'tina@example.com'),
('Varun', 18, '12th', 'varun@example.com'),
('Sneha', 16, '10th', 'sneha@example.com'),
('Aakash', 17, '11th', 'aakash@example.com'),
('Meera', 15, '9th', 'meera@example.com'),
('Rohan', 18, '12th', 'rohan@example.com');
```

---

### Step 4: Create `Accounts` Table for Transactions

```sql
CREATE TABLE accounts (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    balance INT
);

INSERT INTO accounts VALUES 
(1, 'Alice', 5000),
(2, 'Bob', 3000);
```

---

## ⚙️ How the Code Works

- **`createStudent()`**: Adds a new student to the database.
- **`getStudentById()`**: Retrieves and displays student details by ID.
- **`updateStudentName()`**: Updates the name of a student.
- **`deleteStudent()`**: Deletes a student record by ID.
- **`main()`**: Provides a menu-driven CLI to perform the above operations.

---
---

## 🧪 How to Run

1. Make sure MySQL server is running.
2. Open your project in IntelliJ IDEA.
3. Ensure the JDBC `.jar` is added to project libraries.
4. Replace DB credentials if needed in `StudentCRUD.java`.
5. Run `StudentCRUD.java` → use the CLI to interact with your DB!

---