package com.food.services;

import com.food.entity.Orders;

import java.util.List;

public interface OrderService {
    public void addOrder(Orders orders);

    public List<Orders> showOrders(Integer userId);
}