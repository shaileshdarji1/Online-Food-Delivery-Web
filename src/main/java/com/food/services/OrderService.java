package com.food.services;

import com.food.entity.Carts;
import com.food.entity.Orders;
import com.food.entity.User;

import java.util.List;

public interface OrderService {
    public void addOrder(List<Orders> orders);

    public List<Orders> findAllOrder();
    public List<Orders> showOrders(User user);

    public List<Orders> getOrderfromCart(List<Carts> carts);

    public long count();
}