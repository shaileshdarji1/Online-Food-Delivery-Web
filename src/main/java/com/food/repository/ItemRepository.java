package com.food.repository;

import com.food.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{
    @Query("select i from Item i where i.itemId=?1")
    public Item findItem(Integer item_id);
}
