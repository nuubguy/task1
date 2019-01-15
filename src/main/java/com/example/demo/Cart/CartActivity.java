package com.example.demo.Cart;

public interface CartActivity {

    Cart addToCart(Order order,int cartId);
    boolean checkOutItem(int cartId);
}
