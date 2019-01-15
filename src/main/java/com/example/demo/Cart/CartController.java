package com.example.demo.Cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

import static com.example.demo.Cart.Const.Cart.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    ResponseEntity fetchCart(@PathVariable int cartId){
        try{
            return new ResponseEntity(cartService.fetchCart(cartId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(DATA_NOT_FOUND,HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    ResponseEntity addToCart(@RequestBody Order order, @PathVariable int cartId){
        try{
            cartService.addToCart(order,cartId);
            return new ResponseEntity(SUCCESS_ADD_TO_CART,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(FAILED_ADD_TO_CART,HttpStatus.BAD_REQUEST);
        }
    }


    @PostUpdate
    @RequestMapping("/checkout")
    ResponseEntity checkOutItem(@PathVariable int cartId){
        try{
            cartService.checkOutItem(cartId);
            return new ResponseEntity(SUCCESS_CHECKOUT,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(FAILED_TO_CHECKOUT,HttpStatus.BAD_REQUEST);
        }
    }

}
