package com.food.services.impl;

import com.food.entity.Orders;
import com.food.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder(Orders orders) {

    }

    @Override
    public List<Orders> showOrders(Integer userId) {
        return null;
    }
}
