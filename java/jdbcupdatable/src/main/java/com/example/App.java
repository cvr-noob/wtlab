package com.example;

import java.sql.*;

public class App {
    static String rowToString(ResultSet rs) throws Exception {
        return rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email");
    }

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/wtdb", "root", "password"
        );

        Statement stmt = conn.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE
        );

        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        
        rs.last();
        System.out.println("Last row: " + rowToString(rs));

        rs.first();
        System.out.println("First row: " + rowToString(rs));

        rs.beforeFirst();
        System.out.println("All rows:");
        while (rs.next()) {
            System.out.println(rowToString(rs));
        }

        rs.first();
        rs.updateString("name", "Reddy");
        rs.updateRow();
        System.out.println("Updated: " + rowToString(rs));

        rs.moveToInsertRow();
        rs.updateInt("id", 10);
        rs.updateString("name", "NewUser");
        rs.updateString("email", "newuser@example.com");
        rs.insertRow();
        System.out.println("Inserted: " + rowToString(rs));

        rs.close();
        stmt.close();
        conn.close();
    }
}
