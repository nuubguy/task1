package com.example.demo.Cart;


import com.example.demo.Item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

    @Query(value = "select * FROM  Cart where cartId = ?1", nativeQuery = true)
    Cart fetchById(int cartId);

}
