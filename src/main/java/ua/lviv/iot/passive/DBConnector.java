package ua.lviv.iot.passive;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/nykyforuk_db?useUnicode=true&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USERNAME = "user";
    private static final String PASSWORD = System.getenv("PASSWORD");
    private static Connection connection;

    public DBConnector() {
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null || connection.isClosed()) {
                try {
                    connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
