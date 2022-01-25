package com.company.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Create a connection
        String url = "jdbc:mysql://localhost:3306/test";
        String username ="root";
        String password ="root";
        Connection connection = DriverManager.getConnection(url,username,password);
        String query = "insert into student(sName,sFaculty,sContact) values (?,?,?)";
        System.out.println("Enter Student Name: ");
        String sName = scanner.nextLine();
        System.out.println("Enter Student Faculty: ");
        String sFaculty = scanner.nextLine();
        System.out.println("Enter Student Contact Number: ");
        String sContact = scanner.nextLine();
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1,sName);
        preparedStatement.setString(2,sFaculty);
        preparedStatement.setString(3,sContact);
        preparedStatement.executeUpdate();
        System.out.println("Inserted!!!!");
        connection.close();


    }
}
