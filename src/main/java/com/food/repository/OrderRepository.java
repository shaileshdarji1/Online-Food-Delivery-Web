package com.food.repository;

import com.food.entity.Orders;
import com.food.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query("select o from Orders o where o.user=?1")
    public List<Orders> findOrderByUser(User user);

    public List<Orders> findAll();
}
