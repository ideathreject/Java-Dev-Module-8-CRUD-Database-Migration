package jdbc;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Database.getInstance().getConnection();) {
            DatabaseQueryService service = new DatabaseQueryService();
            List<LongestProjects> longestProjectsList = service.longestProjects(conn);
            List<WorkerWithMaxSalary> workerWithMaxSalaryList = service.workerWithMaxSalaries(conn);
            List<MaxProjectCountClient> maxProjectCountClientList = service.maxProjectCountClients(conn);
            List<YoungestEldestWorker> youngestEldestWorkerList = service.youngestEldestWorkers(conn);
            List<ProjectPrice> projectPriceList = service.projectPrices(conn);
            workerWithMaxSalaryList.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Query execute error: " + e.getMessage());
        }

    }
}
