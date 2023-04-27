package com.sprint2.gui;

public class OrderItem {


    private Item item;
    private String addons;
    private String comments;
    private int quantity;
    private String tableID;
    private String waiterID;

    public OrderItem(Item item, int quantity, String addons, String comments) {
        this.item = item;
        this.quantity = quantity;
        this.addons = addons;
        this.comments = comments;
    }
    public Item getItem() {
        return item;
    }

    public String getAddons() {
        return addons;
    }

    public String getComments() {
        return comments;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTableID() {
        return tableID;
    }

    public String getWaiterID() {
        return waiterID;
    }
}
