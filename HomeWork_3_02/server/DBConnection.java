package HomeWork_3_02.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private DBConnection() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myscheme",
                    "root",
                    "P@ssw0rd"
            );
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during establishing DB connection", throwables);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throw new RuntimeException("SWW during connection close", throwables);
        }
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException("SWW during rollback", e);
        }
    }
}
