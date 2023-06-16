package com.food.services.impl;

import com.food.dto.UserDto;
import com.food.entity.Carts;
import com.food.entity.Orders;
import com.food.entity.User;
import com.food.repository.OrderRepository;
import com.food.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(List<Orders> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public List<Orders> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Orders> showOrders(User user) {
        return orderRepository.findOrderByUser(user);
    }

    @Override
    public List<Orders> getOrderfromCart(List<Carts> cart) {
        List<Orders> orders = cart.stream().map(c->new Orders(c.getItem().getName(),c.getQuantity(),c.getUser(),c.getItem(),c.getItem().getPrice())).collect(Collectors.toList());
        return orders;
    }

    @Override
    public long count() {
        return orderRepository.count();
    }
}
