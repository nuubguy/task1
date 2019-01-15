package com.example.demo.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Item implements Serializable {

    @Id
    String itemId;

    @Column
    @NotNull
    String itemName;

    @Column
    @NotNull
    int itemPrice;

    @Column
    @NotNull
    int itemQuantity;

    @Version
    @Column(name = "version")
    public Integer version;

    public Item() {
    }

    public Item(String itemId, @NotNull String itemName, @NotNull int itemPrice, @NotNull int itemQuantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void decrementQuantity(int quantity){
        this.itemQuantity -= quantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
