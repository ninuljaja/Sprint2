package com.sprint2.gui;

public class Orders {
    private int orderNum;
    private String orderDate;
    private String tableID;
    private status orderStatus;
    private String[] items;

    public enum status {
        READY,
        OCCUPIED,
        DIRTY
    }
    public Orders(String[] order){
        try{
            orderNum = Integer.parseInt(order[0]);
            orderDate = order[1];
            tableID = order[2];
            orderStatus = status.valueOf(order[3]);
            items = order[4].split(";");
        } catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }

}
