package com.company.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectJdbc {
    public static void main(String[] args) {
        try{
            // load the driver:
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            String url = "jdbc:mysql://localhost:3306/test";
            String username ="root";
            String password ="root";
            Connection connection = DriverManager.getConnection(url,username,password);

            // Creating query
            String query = "create table student(sId int(20) primary key auto_increment, " +
                    "sName varchar(200),sFaculty varchar(200), sContact varchar(15))";

            // create a statement
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created!!");
            connection.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
