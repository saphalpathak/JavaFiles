package com.company.hms;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    static Connection connection;
    static{
        try {
            connection = ConnectionProvider.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void create(String tableName) throws SQLException {
        String query = "create table "+tableName + "(id int primary key auto_increment, time varchar(100)," +
                " work varchar(30))";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
