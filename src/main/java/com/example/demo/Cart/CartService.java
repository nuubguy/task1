package com.example.demo.Cart;

import com.example.demo.Item.Item;
import com.example.demo.Item.ItemService;
import com.example.demo.User.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartActivity{

    @Autowired
    ItemService itemService;

    @Autowired
    CartRepository cartRepository;

    public Cart fetchCart(int cartId){
        return cartRepository.fetchById(cartId);
    }

    public Cart createCart(Client client){
        return cartRepository.save(new Cart(client));
    }

    @Override
    public Cart addToCart(Order order, int cartId) {
        String itemOrder = order.getItemName();

        Cart cartResult = cartRepository.fetchById(cartId);
        Item itemResult = itemService.fetchItem(itemOrder);

        if (itemResult!=null && itemResult.getItemQuantity() - order.getQuantity()>=0){
            itemResult.setItemQuantity(order.getQuantity());
            cartResult.addToCart(itemResult);
        }

        return cartResult;

    }

    @Override
    public boolean checkOutItem(int cartId) {
        Cart cartResult = cartRepository.fetchById(cartId);

        if(!stillAvailable(cartResult)){
            return false;
        }

        for(Item item : cartResult.getItems()){
            Item itemResult = itemService.fetchItem(item.getItemName());
            itemResult.decrementQuantity(item.getItemQuantity());
            itemService.saveItem(itemResult);

            cartResult.clearCart();
            cartRepository.save(cartResult);
        }

        return true;
    }

    public boolean stillAvailable(Cart cartResult){
        for(Item item: cartResult.getItems()){
            Item itemResult = itemService.fetchItem(item.getItemName());
            if(itemResult.getItemQuantity()-(item.getItemQuantity())<0){
                return false;
            }
        }
        return true;
    }
}
