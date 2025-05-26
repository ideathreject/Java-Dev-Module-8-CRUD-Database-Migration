package jdbc;
import org.flywaydb.core.Flyway;

public class MigrationService {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./data/module5BD", "", "")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();

    }
}
