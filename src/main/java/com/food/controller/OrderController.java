package com.food.controller;

import com.food.dto.OrdersDto;
import com.food.entity.Orders;
import com.food.services.ItemService;
import com.food.services.OrderService;
import com.food.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("/{userId}")
    @ResponseBody
    public List<Orders> showOrders(@PathVariable("userId") Integer userId){
        System.out.println(userId);
        return orderService.showOrders(userId);
    }

    @RequestMapping("/add_order")
    public String addOrder(@RequestBody OrdersDto ordersDto){
        if(ordersDto != null){
            Orders orders = modelMapper.map(ordersDto, Orders.class);
            orders.setItem(itemService.getItem(ordersDto.getItemId()));
            orders.setUser(userService.getUser(ordersDto.getUserId()));
            orderService.addOrder(orders);
            System.out.println(ordersDto);
            return "Success";
        }
        return "Failed";
    }
}
