package com.company.hms;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private ConnectionProvider(){

    }
    private static Connection connection;
    public static Connection getConnection() throws Exception{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthmanagementsystem", "root", "root");
        }
        return  connection;
    }
}
