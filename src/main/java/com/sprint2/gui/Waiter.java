package com.sprint2.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Waiter extends Employee {

    private ArrayList<Table> tables = new ArrayList<>();

    private List<OrderItem> orderItems = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
            ioex.printStackTrace();
        }
    }

    public void createOrder(Table table, ArrayList<OrderItem> orderItems){

            try {
                int orderNumber = lastOrderNumber() + 1;

                FileWriter writer = new FileWriter("Orders.csv", true);
                writer.write(orderNumber + "," + formatter.format(LocalDateTime.now()) + "," + table.getTableID() + "," +
                        "IN_PROCESS" + "," + getEmployeeID() + "\n");
                writer.close();

                writer = new FileWriter("OrderDetails.csv", true);
                for(OrderItem items : orderItems) {
                    writer.write(orderNumber + "," + items.getItem().getItemName() + "," + items.getAddons() + "," +
                            items.getComments() + "," + items.getQuantity() + "\n");
                    writer.close();
                }
            }
            catch(IOException e) {
                e.printStackTrace();
            }


    }
    public OrderItem addOrderItem(Item item, int quantity, String addons, String comments){
        return new OrderItem(item, quantity, addons, comments);
    }

    public int lastOrderNumber() {
        int lastNumber = 0;
        try {
            File file = new File("Orders.csv");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                lastNumber = Integer.parseInt(data[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return lastNumber;
    }
}
