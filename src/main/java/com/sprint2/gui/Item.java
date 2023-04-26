package com.sprint2.gui;

public class Item {
    private String itemCode;
    private String itemName;
    private String category;
    private float price;
    private String description;

    public Item(){
    }
    public Item(String[] item){
        itemCode = item[0];
        itemName = item[1];
        category = item[2];
        try{
            price = Float.parseFloat(item[3]);
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        description = item[4];
    }
    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
