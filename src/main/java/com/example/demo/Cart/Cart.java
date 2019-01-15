package com.example.demo.Cart;

import com.example.demo.Item.Item;
import com.example.demo.User.Client;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int cartId;

    @Version
    @Column(name = "version")
    public Integer version;

    @OneToMany
    private Set<Item>items;

    @OneToOne
    private Client client;

    public Cart() {
    }

    public Cart(Client client) {
        this.items = new HashSet<>(0);
        this.client = client;
    }


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void addToCart(Item item){
        this.items.add(item);
    }

    public void clearCart(){
        this.items.clear();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
