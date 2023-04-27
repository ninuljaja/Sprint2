package com.sprint2.gui;

public class Order {
    private int orderNum;
    private String orderDateTime;
    private String tableID;
    private status orderStatus;
    private String[] items;
    private int waiterID;

    public enum status {
        READY,
        IN_PROCESS,
        COMPLETED
    }
    public Order(String[] order){
        try{
            orderNum = Integer.parseInt(order[0]);
            orderDateTime = order[1];
            tableID = order[2];
            orderStatus = status.valueOf(order[3]);
            items = order[4].split(";");
            waiterID = Integer.parseInt(order[5]);
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }

}
