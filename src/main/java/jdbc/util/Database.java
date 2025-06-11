package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
    private static final String DB_URL = "jdbc:h2:./data/module5BD";

    private Database() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("FAILED TO CONNECT TO DATABASE: " + e.getMessage());
            throw new RuntimeException("Database connection failed", e);
        }
    }
}

