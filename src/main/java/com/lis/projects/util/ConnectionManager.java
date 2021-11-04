package com.lis.projects.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";

    static {
        loadDriver();
    }

    private ConnectionManager() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesManager.get(URL_KEY),
                    PropertiesManager.get(USERNAME_KEY),
                    PropertiesManager.get(PASSWORD_KEY)
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
