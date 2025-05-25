package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            String dbUrl = "jdbc:h2:./data/module5BD";
            this.connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.err.println("FAILED TO CONNECT TO DATABASE" + e.getMessage());
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            return instance;
        } else return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

