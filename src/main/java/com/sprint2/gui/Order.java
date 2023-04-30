package com.sprint2.gui;

import java.util.ArrayList;

public class Order {
    private int orderNum;
    private String orderDateTime;
    private String tableID;
    private status orderStatus;

    private int waiterID;
    private ArrayList<OrderItem> orderItems;

    public enum status {
        READY,
        IN_PROCESS,
        COMPLETED,
    }
    public Order(String[] order, ArrayList<OrderItem> orderItems){
        try{
            orderNum = Integer.parseInt(order[0]);
            orderDateTime = order[1];
            tableID = order[2];
            orderStatus = status.valueOf(order[3]);

            waiterID = Integer.parseInt(order[4]);
            this.orderItems = orderItems;
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public String getTableID() {
        return tableID;
    }

    public status getOrderStatus() {
        return orderStatus;
    }



    public int getWaiterID() {
        return waiterID;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }
}
