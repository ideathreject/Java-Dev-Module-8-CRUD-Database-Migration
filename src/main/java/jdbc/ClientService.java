package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientService {
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client (name) VALUES (?)";
    private static final String GET_CLIENT_SQL = "SELECT name FROM client WHERE id = ?";
    private static final String UPDATE_CLIENT_SQL = "UPDATE client SET name = ? WHERE id = ?";
    private final Database database;

    public ClientService(Database database) {
        this.database = database;
    }

    public long create(String name) {
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, name);
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating client failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating client failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while creating client", e);
        }
    }

    public String getById(long id) {
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CLIENT_SQL)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) return resultSet.getString("name");
            else throw new RuntimeException("Cannot find client with id " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
