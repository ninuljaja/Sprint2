package com.sprint2.gui;

public class Table {
    private String tableID;
    private int waiterID;
    private String status;

    public Table(){

    }
    public Table(String[] table){
        tableID = table[0];
        try{
            waiterID = Integer.parseInt(table[1]);
        } catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
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
}
