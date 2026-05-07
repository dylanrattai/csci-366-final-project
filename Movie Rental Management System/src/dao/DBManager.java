/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 *
 * @author alq24
 */
public class DBManager {
    static String URL = "jdbc:postgresql://localhost:5432/simple_company";
    static String username = "postgres";
    static String password = "";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }

   
}
