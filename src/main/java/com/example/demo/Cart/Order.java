package com.example.demo.Cart;

public class Order {

    private String itemName;
    private int quantity;

    public Order(String itemId, int quantity) {
        this.itemName = itemId;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
