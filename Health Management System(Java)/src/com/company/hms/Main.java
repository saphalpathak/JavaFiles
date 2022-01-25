package com.company.hms;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("\tEnter:\n\t1 to add account.\n\t2 to save data.\n\t3 to update.\n\t4 to display data.");
        int who = new Scanner(System.in).nextInt();
        if(who != 1 && who != 2 && who != 3 && who != 4){
            System.out.println("Please enter right input!!");
            return;
        }
        System.out.print("Enter your name: ");
        String name = new Scanner(System.in).nextLine();
        switch (who){
            case 1:
                new CreateTable().create(name);
            case 2:
                new InsertData().setInput(name);
                new DisplayData().display(name);
                break;
            case 3:
                new UpdateEntry().update(name);
            case 4:
                new DisplayData().display(name);
                break;
        }
    }
}
