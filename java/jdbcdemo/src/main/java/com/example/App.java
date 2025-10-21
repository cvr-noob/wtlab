package com.example;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/wtdb";
        String username = "root";
        String password = "password";

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected!");

        Statement stmt = conn.createStatement();

        String create = "CREATE TABLE IF NOT EXISTS users("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "name VARCHAR(30),"
                + "email VARCHAR(30))";
        stmt.execute(create);

        String insert = "INSERT INTO users (name, email) VALUES "
                + "('Alice', 'alice@example.com'),"
                + "('Bob', 'bob@example.com')";
        stmt.executeUpdate(insert);

        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            System.out.println(id + " | " + name + " | " + email);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
