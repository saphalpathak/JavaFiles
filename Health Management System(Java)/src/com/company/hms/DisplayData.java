package com.company.hms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayData {
    static Connection connection;
    static{
        try {
            connection = ConnectionProvider.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void display(String name) throws SQLException {
        String query = "select * from "+name;
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(query);
        while(set.next()){
            int id = set.getInt(1);
            String date = set.getString(2);
            String work = set.getString(3);
            System.out.printf("%03d%30s%10s%-20s\n",id,date,"",work);
        }
    }
}
