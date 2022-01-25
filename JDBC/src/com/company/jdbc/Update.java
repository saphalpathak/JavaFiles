package com.company.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Connection connection = ConnectionProvider.getConnection();
        String query = "update student set sName = ?, sFaculty = ?, sContact = ? where sid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        System.out.println("Enter updated name:");
        String uName = scanner.nextLine();
        System.out.println("Enter updated faculty: ");
        String uFaculty = scanner.nextLine();
        System.out.println("Enter updated contact: ");
        String uContact = scanner.nextLine();
        System.out.println("Enter Id: ");
        int sId = scanner.nextInt();
        preparedStatement.setString(1,uName);
        preparedStatement.setString(2,uFaculty);
        preparedStatement.setString(3,uContact);
        preparedStatement.setInt(4,sId);
        preparedStatement.executeUpdate();
        connection.close();
    }
}
