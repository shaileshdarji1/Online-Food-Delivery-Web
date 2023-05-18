package com.food.services.impl;

import com.food.entity.Orders;
import com.food.repository.OrderRepository;
import com.food.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public List<Orders> showOrders(Integer userId) {
        return orderRepository.showOrders(userId);
    }
}
