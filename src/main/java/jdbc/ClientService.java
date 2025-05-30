package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client (name) VALUES (?)";
    private static final String GET_CLIENT_SQL = "SELECT name FROM client WHERE id = ?";
    private static final String UPDATE_CLIENT_SQL = "UPDATE client SET name = ? WHERE id = ?";
    private static final String DELETE_CLIENT_SQL = "DELETE FROM client WHERE id = ?";
    private static final String GET_ALL_CLIENTS_SQL = "SELECT * FROM client";
    private final Database database;

    public ClientService(Database database) {
        this.database = database;
    }

    public long create(String name) {
        validateName(name);
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_CLIENT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            int result = statement.executeUpdate();
            if (result == 0) {
                throw new SQLException("Creating client failed, no rows affected.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Creating client failed, no ID obtained.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while creating client", e);
        }
    }

    public void validateName(String name) {
        if (name == null || name.length() < 3 || name.length() > 1000) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    public String getById(long id) {
        validateId(id);
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CLIENT_SQL)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            } else {
                throw new RuntimeException("Cannot find client with id " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setName(long id, String name) {
        validateName(name);
        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_SQL)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            int result = statement.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Client with id " + id + " not found. Update failed.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating client name");
        }
    }

    public void deleteById(long id) {
        validateId(id);

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_SQL)) {
            statement.setLong(1, id);
            int result = statement.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Client with id " + id + " not found. Delete failed.");
            } else System.out.println("Client with id " + id + " DELETED");
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting client", e);
        }
    }

    public List<Client> listAll() {
        List<Client> result = new ArrayList<>();

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_CLIENTS_SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                result.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
