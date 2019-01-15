package com.example.demo.Cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.Cart.Const.Cart.FAILED_ADD_TO_CART;
import static com.example.demo.Cart.Const.Cart.SUCCESS_ADD_TO_CART;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    ResponseEntity addToCart(@RequestBody Order order, @PathVariable int cartId){
        try{
            cartService.addToCart(order,cartId);
            return new ResponseEntity(SUCCESS_ADD_TO_CART,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(FAILED_ADD_TO_CART,HttpStatus.BAD_REQUEST);
        }

    }

}
