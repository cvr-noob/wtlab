package com.example;

import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/wtdb", "root", "password"
        );

        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO users (name, email) VALUES ('CVR', 'cvr@cvr.ac.in')");
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        while(rs.next()) {
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