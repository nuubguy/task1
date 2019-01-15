package com.example.demo.User;

import com.example.demo.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserActivity {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CartService cartService;


    @Override
    public Optional<Client> fetchUser(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Client saveUser(Client user) {

        try{
            userRepository.save(user);
            cartService.createCart(user);
            return user;
        }catch (RuntimeException e){
            return null;
        }

    }
}
