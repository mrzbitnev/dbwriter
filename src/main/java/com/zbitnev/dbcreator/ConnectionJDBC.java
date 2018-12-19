package com.zbitnev.dbcreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC implements AutoCloseable {
        Connection connectionMydb = null;
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return connectionMydb = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5433/mydb", "owner", "*****");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        throw new SQLException();
    }

    @Override
    public void close() throws Exception {
        connectionMydb.close();
    }
}
