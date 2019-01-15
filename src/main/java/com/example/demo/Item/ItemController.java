package com.example.demo.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    ResponseEntity fecthItem(@RequestParam(value = "itemname")String itemname){
        return new ResponseEntity(itemService.fetchItem(itemname), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity saveItem(@RequestBody Item item){
        return new ResponseEntity(itemService.saveItem(item),HttpStatus.ACCEPTED);
    }
}
