package com.example.demo.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,String> {

    @Query(value = "select * FROM  Item where itemName = ?1", nativeQuery = true)
    Item fetchItem(String itemName);

}
