package com.sprint2.gui;

import java.util.List;

public class OrderItem {
    private Item item;
    private List<Item> addons;
    private String comments;
    private int quantity;
    private String tableID;
    private String waiterID;

    public OrderItem(Item item, int quantity, List<Item> addons, String comments) {
        this.item = item;
        this.quantity = quantity;
        this.addons = addons;
        this.comments = comments;
    }
}
