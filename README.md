
# Java Dev Module 8 – CRUD & Flyway Migration

## 📚 Project Description

This Java project demonstrates working with a relational database using **JDBC** and **Flyway** for database migrations. The application includes a `ClientService` class that performs basic CRUD operations on a `client` table.

---

## ✅ Task 1 – Use Flyway for Migrations

The project was refactored to use **Flyway** for managing database schema and initial data.

- Two migration scripts are executed automatically on application startup:
  - `V1__init_db.sql` – creates database tables.
  - `V2__populate_db.sql` – inserts initial data.
- The previous logic for manually reading and executing SQL files was removed.
- Migration files are stored in the `resources/db/migration/` directory.

---

## ✅ Task 2 – Implement CRUD Service for `client` Entity

A class named `ClientService` was implemented to perform basic CRUD operations.

### Implemented Methods

| Method                              | Description                                                                 |
|-------------------------------------|-----------------------------------------------------------------------------|
| `long create(String name)`          | Adds a new client with the given name. Returns the ID of the newly created client. |
| `String getById(long id)`           | Returns the name of the client by ID.                                      |
| `void setName(long id, String name)`| Updates the name of the client with the specified ID.                      |
| `void deleteById(long id)`          | Deletes the client by ID.                                                  |
| `List<Client> listAll()`            | Returns all clients as a list of `Client` objects.                         |

The `Client` class includes the following fields:

```java
private long id;
private String name;
```

---

##  Input Validation

Input data is validated in all methods of `ClientService`. For example:

- Name must not be `null` or blank.
- Name must be between 2 and 100 characters.
- ID must be > 0

If the input is invalid, the method throws an `IllegalArgumentException`.

---
