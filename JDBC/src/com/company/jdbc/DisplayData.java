package com.company.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayData {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionProvider.getConnection();
        String query = "select * from student";
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(query);
        while(set.next()){
            int id = set.getInt(1);
            String name = set.getString(2);
            String faculty = set.getString(3);
            String contact = set.getString(4);
            String s = " ";
            System.out.printf("%03d %5s %-20s %-15s %-15s\n",id,s,name,faculty,contact);
        }
    }
}
