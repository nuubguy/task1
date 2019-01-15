package com.example.demo.Cart.Const;

public enum Cart {
    SUCCESS_ADD_TO_CART("Your item has been added to cart"),
    SUCCESS_CHECKOUT("Yout item has been checkout"),
    FAILED_ADD_TO_CART("Your item failed to cart"),
    FAILED_TO_CHECKOUT("Your Item has been failed to checkout"),
    DATA_NOT_FOUND("Data not found");
    ;

    Cart(String s) {

    }
}
