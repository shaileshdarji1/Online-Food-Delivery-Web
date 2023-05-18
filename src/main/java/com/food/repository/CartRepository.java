package com.food.repository;

import com.food.entity.Carts;
import com.food.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Carts, Integer> {

    @Query("select c from Carts c where c.user=?1")
    public List<Carts> findAllItemByUser(User user);

    public List<Carts> findAll();

    @Query("delete from Carts c where c.user=?1")
    public void deleteItemByUser(User user);
}