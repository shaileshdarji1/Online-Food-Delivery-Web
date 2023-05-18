package com.food.repository;

import com.food.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

//    public Orders AddOrder(Orders order);

    @Query("select o from Orders o where o.user.userId=?1")
    public List<Orders> showOrders(Integer userId);
}
