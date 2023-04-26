package com.sprint2.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Waiter extends Employee {

    private ArrayList<Table> tables = new ArrayList<>();

    private List<OrderItem> orderItems = new ArrayList<>();
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

    public void createOrder(){

    }
    public OrderItem addOrderItem(Item item, int quantity, List<Item> addons, String comments){
        return new OrderItem(item, quantity, addons, comments);
    }
}
