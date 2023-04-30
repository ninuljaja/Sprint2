package com.sprint2.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Session {
    private static Session instance = null;
    private Employee user;
    private String mode;
    private Table selectedTable;
    private ArrayList<Order> allOrdersNotComplete = new ArrayList<>();
    private Hashtable<String, ArrayList<Order>> activeOrders = new Hashtable<>();
    private String[] tables = {"A1","A2","A3","A4","A5","A6","B1","B2","B3","B4","B5","B6","C5","C6","D5","D6","E1","E2","E3","E4","E5","E6","F1","F2","F3","F4","F5","F6"};

    private Session() {
        readOrdersFile();
        for(String table : tables) {

            addData(table, tableOrders(table));
        }

        ActivityLogging.LoadLogs();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setSelectedTable(Table selectedTable) {
        this.selectedTable = selectedTable;
    }

    public Table getSelectedTable() {
        return selectedTable;
    }

    public void addData(String table, ArrayList<Order> orders) {
        activeOrders.put(table, orders);

    }

    public void removeData(String table) {
        activeOrders.remove(table);
    }

    public ArrayList<Order> getData(String table) {
        return activeOrders.get(table);
    }
    public ArrayList<Order> tableOrders (String table){
        ArrayList<Order> orders = new ArrayList<>();

        for(Order order : allOrdersNotComplete){
            if(order.getTableID().equalsIgnoreCase(table)){
                orders.add(order);
            }
        }
        return orders;
    }

    public void readOrdersFile(){
        try {
            allOrdersNotComplete.removeAll(allOrdersNotComplete);
            String dataLine = "";
            File myFile = new File("Orders.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            int i = 0;
            while (scan.hasNextLine()) {

                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");

                if(!line[3].equalsIgnoreCase("COMPLETED")) {
                    ArrayList<OrderItem> orderItems = new ArrayList<>();
                    String dataLine2 = "";
                    File myFile2 = new File("OrderDetails.csv");
                    Scanner scan2 = new Scanner(myFile2);
                    scan2.nextLine();
                    while (scan2.hasNextLine()) {
                        dataLine2 = scan2.nextLine();
                        // Split the string by comma
                        String[] line2 = dataLine2.split(",");
                        if (line[0].equalsIgnoreCase(line2[0])) {
                            String dataLine3 = "";
                            File myFile3 = new File("Items.csv");
                            Scanner scan3 = new Scanner(myFile3);
                            scan3.nextLine();
                            while (scan3.hasNextLine()) {
                                dataLine3 = scan3.nextLine();
                                // Split the string by comma
                                String[] line3 = dataLine3.split(",");
                                if (line3[1].equalsIgnoreCase(line2[1])) {
                                    orderItems.add(new OrderItem(new Item(line3), Integer.parseInt(line2[4]),line2[2],line2[3]));
                                    break;
                                }
                            }
                            scan3.close();

                        }
                    }
                    scan2.close();
                    Order newOrder = new Order(line, orderItems);
                    allOrdersNotComplete.add(newOrder);
                }
            }
            scan.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
