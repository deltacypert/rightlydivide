package com.aca.backend.dao;

import java.sql.*;

public class MariaDbUtil {
    private static String connectionUrl =
            "jdbc:mariadb://localhost:3306/rightlydivide?user=root&password=password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = MariaDbUtil.getConnection();
        if (null != connection) {
            System.out.println("A real connection");
        } else {
            System.out.println("Help. Connection is null.");
        }
    }
}
