package jdbc;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) {
        try (Connection conn = Database.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = Files.readString(Path.of("sql/init_db.sql"));
            stmt.executeUpdate(sql);
        } catch (SQLException | IOException e) {
            System.err.println("Failed to initialize database: " + e.getMessage());
        }
    }
}