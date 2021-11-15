package com.example.javafxco1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnect {

    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipensiondb","root","root");
        return connection;
    }

}
