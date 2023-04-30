package com.sprint2.gui;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileNotFoundException;
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
    private ArrayList<Order> allOrders = new ArrayList<>();
    private Hashtable<String, ArrayList<Order>> activeOrders = new Hashtable<>();
    private String[] tables = {"A1","A2","A3","A4","A5","A6","B1","B2","B3","B4","B5","B6","C5","C6","D5","D6","E1","E2","E3","E4","E5","E6","F1","F2","F3","F4","F5","F6"};

    private Session() {


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
    public void loadActiveOrders() throws FileNotFoundException {
        inCompleteOrdersList();
        for(String table : tables) {

            addData(table, tableOrders(table));
        }
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

    public void inCompleteOrdersList() throws FileNotFoundException {
        allOrdersNotComplete.removeAll(allOrdersNotComplete);
        allOrders = orderList();
        if(!allOrders.isEmpty() && allOrders != null){
            for(Order order : allOrders){
                if(!order.getOrderStatus().equalsIgnoreCase("COMPLETED")) {
                    allOrdersNotComplete.add(order);
                }
            }
        }
    }

    public void viewOrder(ArrayList<TableColumn<String[], String>> tableColumn, ObservableList<String[]> list, ArrayList<OrderItem> ordItems, TableView<String[]> listTbl){
        float totalPrice = 0;

        for(OrderItem items : ordItems) {
            String[] parts = new String[4];
            parts[0] = items.getItem().getItemName();
            parts[1] = items.getAddons();
            parts[2] = items.getComments();
            parts[3] = String.valueOf(items.getItem().getPrice());
            list.add(parts);
            totalPrice += items.getItem().getPrice();
        }
        String[] subtotalParts = {"", "", "Subtotal", String.valueOf(totalPrice)};
        list.add(subtotalParts);
        float tax = totalPrice*7/100;
        String[] taxParts = {"", "", "Tax", String.format("%.2f", tax)};
        list.add(taxParts);
        String[] totalParts = {"", "", "Total", String.format("%.2f", (tax + totalPrice))};
        list.add(totalParts);
        int i = 0;
        for (TableColumn<String[], String> tColumn : tableColumn) {
            int finalI = i;
            tColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[finalI]));
            i++;
            tColumn.setCellFactory(param -> new WrappingTextCell());
        }

        listTbl.setItems(list);
    }
    public Employee findEmployee(String emploeeID){
        ArrayList<Employee> employees = employeeList();
        if(!employees.isEmpty() && employees != null){
            for(Employee employee : employees){
                if(String.valueOf(employee.getEmployeeID()).equalsIgnoreCase(emploeeID)){
                    return employee;
                }
            }
        }
        return null;
    }

    public ArrayList<Employee> employeeList(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String dataLine = "";
            File myFile = new File("Employee.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                Employee emp = new Employee(line);
                employees.add(emp);
            }
            scan.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            return employees;
        }
    }
    public ArrayList<Table> tableList(){
        ArrayList<Table> allTables = new ArrayList<>();
        try {
            String dataLine = "";
            File myFile = new File("Tables.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                allTables.add(new Table(line));
            }
            scan.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return allTables;
    }

    public Table getTable(String tableID){
        ArrayList<Table> allTables = tableList();
        if(!allTables.isEmpty() && allTables != null){
            for(Table table : allTables) {
                if (table.getTableID().equalsIgnoreCase(tableID)) {
                        return table;
                    }
                }
            }
        return null;
    }

    public ArrayList<Order> orderList() throws FileNotFoundException {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String dataLine = "";
            File myFile = new File("Orders.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
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
                                orderItems.add(new OrderItem(new Item(line3), Integer.parseInt(line2[4]), line2[2], line2[3]));
                                break;
                            }
                        }
                        scan3.close();
                    }
                }
                scan2.close();
                Order newOrder = new Order(line, orderItems);
                orders.add(newOrder);
            }
            scan.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            return orders;
        }
    }
}
