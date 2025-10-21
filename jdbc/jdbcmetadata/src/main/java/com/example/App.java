package com.example;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/wtdb", "root", "password"
        );

        DatabaseMetaData md = conn.getMetaData();
        System.out.println("Product: " + md.getDatabaseProductName());
        System.out.println("Product Version: " + md.getDatabaseProductVersion());
        System.out.println("Driver: " + md.getDriverName());
        System.out.println("Driver Version: " + md.getDriverVersion());
        System.out.println("JDBC Version: " + md.getJDBCMajorVersion());
        System.out.println("URL: " + md.getURL());
        System.out.println("Username: " + md.getUserName());

        conn.close();
    }
}
