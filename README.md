# Java Spring Framework and Basics

## Exercise 1:

### Overview

This project consists of a simple RESTful API developed using the Spring Framework for managing the data of a `Driver` entity. The API follows best practices for CRUD operations.

#### Table Structure

- **Table Name:** driver
- **Columns:** id, name, age

### API Endpoints

1. **Get All Drivers**
   - **Endpoint:** `GET /api/v1/drivers`
   - **Description:** Retrieve a list of all drivers.

2. **Get Driver by ID**
   - **Endpoint:** `GET /api/v1/drivers/{id}`
   - **Description:** Retrieve details of a specific driver using the driver's ID.

3. **Create a Driver**
   - **Endpoint:** `POST /api/v1/drivers`
   - **Description:** Create a new driver entry.
   - **Request Body:**
     ```json
     {
       "name": "Sam Sam",
       "age": 30
     }
     ```

4. **Update a Driver**
   - **Endpoint:** `PUT /api/v1/drivers/{id}`
   - **Description:** Update details of a specific driver using the driver's ID.
   - **Request Body:**
     ```json
     {
       "name": "Updated Name",
       "age": 35
     }
     ```

5. **Delete a Driver**
   - **Endpoint:** `DELETE /api/v1/drivers/{id}`
   - **Description:** Delete a specific driver using the driver's ID.

### How to Run

To run the project, you can use an IDE (e.g., IntelliJ, Eclipse) or build and run it from the command line using Maven.

```bash
cd first_task
mvn spring-boot:run
```
# Exercise 2:

## Overview

This project includes a simple `Department` class that holds a map of student grades. The `Student` class has attributes `name` and `lastName`.

### Class Structure

- **Class:** `Department`

### Methods

1. **Add Student and Grade**
   - **Method:** `addStudent(Student student, int grade)`
   - **Description:** Adds a student and their grade into the map. If a student with the same last name is already present, the existing entry is replaced with the new entry.

2. **Print Student Grades**
   - **Method:** `printStudentGrades()`
   - **Description:** Prints each student and their corresponding grade.

## How to Use

To use the `Department` class, you can instantiate an object and call the provided methods.

```java
public static void main(String[] args) {
        Department department = new Department();

        Student student1 = new Student("John", "Wick");
        Student student2 = new Student("Jane", "Wick");

        department.addStudent(student1, 85);
        department.addStudent(student2, 90);

        department.printStudentGrades();
        System.out.println();

        Student student3 = new Student("John", "Pretty");
        department.addStudent(student3, 95);

        department.printStudentGrades();
    }

