package tasks_jdbc_02.task0807;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariCPDataSource {
    private static HikariCPDataSource instance;
    private HikariConfig config;
    private HikariDataSource ds;

    private HikariCPDataSource() {
        //напишите тут ваш код
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        config.setPassword("root");
        config.setUsername("root");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new HikariCPDataSource();
        }
        return instance.ds.getConnection();
    }
}