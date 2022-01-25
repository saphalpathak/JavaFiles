package com.company.hms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InsertData {
    private String work;
    private String time;
    static Connection connection;
    static {
        try {
            connection = ConnectionProvider.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setWork(){
        System.out.print("Enter your work:  ");
        work = new Scanner(System.in).nextLine();
    }
    public void setTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm a");
        time = localDateTime.format(dateTimeFormatter);
    }
    public void setInput(String name) throws SQLException {
        String query = "insert into "+name+"(time,work) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        setWork();
        setTime();
        preparedStatement.setString(1,time);
        preparedStatement.setString(2,work);
        preparedStatement.executeUpdate();
        System.out.println("Done!!!");
    }
}
