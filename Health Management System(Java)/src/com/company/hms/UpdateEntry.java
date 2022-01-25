package com.company.hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEntry {
    static Connection connection;

    static {
        try {
            connection = ConnectionProvider.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(String name) throws SQLException {
        String query = "update "+name+" set work=? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        System.out.println("Enter updated work: ");
        String uWork = new Scanner(System.in).nextLine();
        System.out.println("Enter id: ");
        int id = new Scanner(System.in).nextInt();
        preparedStatement.setString(1,uWork);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();

    }
}
