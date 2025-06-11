package jdbc.service;

import jdbc.model.LongestProjects;
import jdbc.model.MaxProjectCountClient;
import jdbc.model.ProjectPrice;
import jdbc.model.WorkerWithMaxSalary;
import jdbc.model.YoungestEldestWorker;
import jdbc.util.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static final String ERROR_MASSAGE = "Query execution error: ";

    public List<WorkerWithMaxSalary> workerWithMaxSalaries() {
        List<WorkerWithMaxSalary> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("sql/find_max_salary_worker.sql"));
            try (Connection conn = Database.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet resultSet = stmt.executeQuery(sql)) {

                while (resultSet.next()) {
                    WorkerWithMaxSalary worker = new WorkerWithMaxSalary();
                    worker.setId(resultSet.getInt("id"));
                    worker.setName(resultSet.getString("name"));
                    worker.setBirthday(LocalDate.parse(resultSet.getString("birthday")));
                    worker.setLevel(resultSet.getString("level"));
                    worker.setSalary(resultSet.getInt("salary"));
                    result.add(worker);
                }
            }
        } catch (SQLException | IOException e) {
            System.err.println(ERROR_MASSAGE + e.getMessage());
        }

        return result;
    }


    public List<LongestProjects> longestProjects() {
        List<LongestProjects> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("sql/find_longest_project.sql"));

            try (Connection conn = Database.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet resultSet = stmt.executeQuery(sql)
            ) {
                while (resultSet.next()) {
                    LongestProjects longestProjects = new LongestProjects();
                    longestProjects.setId(resultSet.getInt("id"));
                    longestProjects.setClientId(resultSet.getInt("client_id"));
                    longestProjects.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
                    longestProjects.setFinishDate(LocalDate.parse(resultSet.getString("finish_date")));
                    longestProjects.setDurationMonths(resultSet.getInt("duration_months"));
                    result.add(longestProjects);
                }
            }
        } catch (SQLException | IOException e) {
            System.err.println(ERROR_MASSAGE + e.getMessage());
        }

        return result;
    }


    public List<MaxProjectCountClient> maxProjectCountClients() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("sql/find_max_projects_client.sql"));

            try (Connection conn = Database.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet resultSet = stmt.executeQuery(sql)
            ) {
                while (resultSet.next()) {
                    MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                    maxProjectCountClient.setId(resultSet.getInt("id"));
                    maxProjectCountClient.setName(resultSet.getString("name"));
                    maxProjectCountClient.setProjectCount(resultSet.getInt("project_count"));
                    result.add(maxProjectCountClient);
                }
            }
        } catch (SQLException | IOException e) {
            System.err.println(ERROR_MASSAGE + e.getMessage());
        }

        return result;
    }


    public List<YoungestEldestWorker> youngestEldestWorkers() {
        List<YoungestEldestWorker> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("sql/find_youngest_eldest_workers.sql"));

            try (Connection conn = Database.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet resultSet = stmt.executeQuery(sql)
            ) {
                while (resultSet.next()) {
                    YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
                    youngestEldestWorker.setType(resultSet.getString("type"));
                    youngestEldestWorker.setName(resultSet.getString("name"));
                    youngestEldestWorker.setBirthday(LocalDate.parse(resultSet.getString("birthday")));
                    result.add(youngestEldestWorker);
                }
            }
        } catch (SQLException | IOException e) {
            System.err.println(ERROR_MASSAGE + e.getMessage());
        }

        return result;
    }


    public List<ProjectPrice> projectPrices() {
        List<ProjectPrice> result = new ArrayList<>();

        try {
            String sql = Files.readString(Path.of("sql/print_project_prices.sql"));

            try (Connection conn = Database.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet resultSet = stmt.executeQuery(sql);
            ) {
                while (resultSet.next()) {
                    ProjectPrice projectPrice = new ProjectPrice();
                    projectPrice.setId(resultSet.getInt("id"));
                    projectPrice.setClientId(resultSet.getInt("client_id"));
                    projectPrice.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
                    projectPrice.setFinishDate(LocalDate.parse(resultSet.getString("finish_date")));
                    projectPrice.setDurationMonths(resultSet.getInt("duration_months"));
                    projectPrice.setTotalSalary(resultSet.getInt("total_salary"));
                    projectPrice.setProjectCost(resultSet.getInt("project_cost"));
                    result.add(projectPrice);
                }
            }
        } catch (SQLException | IOException e) {
            System.err.println(ERROR_MASSAGE + e.getMessage());
        }

        return result;
    }
}

