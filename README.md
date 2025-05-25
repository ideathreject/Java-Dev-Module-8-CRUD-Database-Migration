
# Database Project with H2

## Project Setup

1. Create a new Gradle project.
2. Add necessary dependencies for working with the H2 database.
3. Create a directory `sql` in the project root.
4. Copy all `.sql` files from the previous assignment into the `sql` directory.

## Tasks

### Task 1 - Create a Utility Class for Database Connection

- Create a singleton class `Database` that encapsulates the logic for working with the database.
- Upon instantiation, the class should establish a connection to the database and store the `Connection` instance.
- Provide a method `getConnection()` to obtain the connection.
- Example usage:

```java
Connection conn = Database.getInstance().getConnection();
```

### Task 2 - Create a Class for Initializing the Database Structure

- Create a class named `DatabaseInitService`.
- Implement a `public static void main(String[] args)` method that reads the file `sql/init_db.sql` and executes its queries on the database.
- Use the previously created `Database` class for working with the database.
- The result of running this class should be an initialized database with correctly created tables and relationships.

### Task 3 - Create a Class for Populating Database Tables

- Create a class named `DatabasePopulateService`.
- Implement a `public static void main(String[] args)` method that reads the file `sql/populate_db.sql` and executes its queries on the database.
- Use the previously created `Database` class for working with the database.
- The result of running this class should be populated database tables.

### Task 4 - Create a Class for Querying Data from the Database

- Create a class named `DatabaseQueryService`.
- Implement methods corresponding to each SELECT SQL file from the previous assignment.
- Each method should:
  - Read the corresponding `.sql` file.
  - Return the appropriate result.
- Name each method following Java Code Conventions.
- Pay attention to the correct return types for each method.
- For example, for the file `find_max_projects_client.sql`, the method signature might look like:

```java
List<MaxProjectCountClient> findMaxProjectsClient();
```

- The class `MaxProjectCountClient` should be defined, for example:

```java
public class MaxProjectCountClient {
    private String name;
    private int projectCount;
}
```

- Use the previously created `Database` class for working with the database.
- After implementing, run each method to ensure it returns correct information and no exceptions occur.

## Usage Example

```java
List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
```


This README describes the structure and tasks of the project and provides guidance on how to implement the database connection, initialization, population, and querying layers.
