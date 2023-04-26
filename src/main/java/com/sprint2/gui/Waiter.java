package com.sprint2.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Waiter extends Employee {

    private ArrayList<Table> tables = new ArrayList<>();
    public Waiter(String[] waiter) {
        super(waiter);
        updateAssignedTables();
    }
    public Waiter(Employee waiter) {
        super(waiter);

    }

    public  ArrayList<Table> getAssignedTable (){
        updateAssignedTables();
        return tables;
    }
    public void updateAssignedTables(){
        try {
            String dataLine = "";
            File myFile = new File("Tables.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                if (line[1].equalsIgnoreCase(String.valueOf(employeeID))) {
                   tables.add(new Table(line));
                }
            }
            scan.close();

        } catch (IOException ioex) {
            System.out.println("Error: " + ioex.getMessage());
        }
    }
}
