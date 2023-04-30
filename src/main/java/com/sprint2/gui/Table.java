package com.sprint2.gui;

import java.util.ArrayList;

public class Table {
    private String tableID;
    private int waiterID;
    private String status;
    private ArrayList<Order> activeOrders = new ArrayList<>();
    private ArrayList<ArrayList<OrderItem>> activeOrderDetails = new ArrayList<>();


    public Table() {

    }

    public Table(String[] table) {
        tableID = table[0];
        try {
            waiterID = Integer.parseInt(table[1]);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        status = table[2];
    }

    public String getTableID() {
        return tableID;
    }

    public int getWaiterID() {
        return waiterID;
    }

    public String getStatus() {
        return status;
    }

    public void setWaiterID(int waiterID) {
        this.waiterID = waiterID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Order> getActiveOrders() {
        return activeOrders;
    }



    public void addToActiveOrders(String[] currentOrder, ArrayList<OrderItem> orderItems) {
        activeOrders.add(new Order(currentOrder, orderItems));
    }
}

