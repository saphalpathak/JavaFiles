package com.company.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertImage {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url,username,password);
        String query = "insert into images(iName,image) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        FileInputStream fileInputStream = new FileInputStream("F:\\myimg.jpg");
        System.out.println("Enter image name: ");
        String iName = new Scanner(System.in).nextLine();
        preparedStatement.setString(1,iName);
        preparedStatement.setBinaryStream(2,fileInputStream,fileInputStream.available());
        preparedStatement.executeUpdate();
        System.out.println("Done");
        connection.close();


    }
}
