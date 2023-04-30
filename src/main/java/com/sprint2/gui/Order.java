package com.sprint2.gui;

import java.util.ArrayList;

public class Order {
    private int orderNum;
    private String orderDateTime;
    private String tableID;
    private String orderStatus;

    private int waiterID;
    private ArrayList<OrderItem> orderItems;


    public Order(String[] order, ArrayList<OrderItem> orderItems){
        try{
            orderNum = Integer.parseInt(order[0]);
            orderDateTime = order[1];
            tableID = order[2];
            orderStatus = order[3];

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

    public String getOrderStatus() {
        return orderStatus;
    }



    public int getWaiterID() {
        return waiterID;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }
}
