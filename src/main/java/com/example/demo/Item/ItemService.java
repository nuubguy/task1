package com.example.demo.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item fetchItem(String itemname){
        return itemRepository.fetchItem(itemname);
    }

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

}
