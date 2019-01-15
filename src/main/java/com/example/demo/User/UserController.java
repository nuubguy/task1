package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity fetchUser(@RequestParam("username") String username){
        return new ResponseEntity(userService.fetchUser(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody Client client){
        return new ResponseEntity(userService.saveUser(client),HttpStatus.ACCEPTED);
    }
}
