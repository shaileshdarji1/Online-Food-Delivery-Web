package com.food.controller;

import com.food.dto.UserDto;
import com.food.entity.Carts;
import com.food.entity.Orders;
import com.food.entity.User;
import com.food.services.CartService;
import com.food.services.OrderService;
import com.food.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    Orders order;

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;
    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("/{userId}")
    @ResponseBody
    public List<Orders> showOrders(@PathVariable("userId") Integer userId) {
        System.out.println(userId);
        return orderService.showOrders(userId);
    }

    @RequestMapping("/add_order")
    public List<Orders> addOrder() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.getCurrentlyLoggedInUser(auth);
        User user = modelMapper.map(userDto, User.class);
        List<Carts> carts = cartService.findCartProductByUser(user);
        List<Orders> orders = null;
        carts.forEach(carts1 -> {
            order.setOrderName(carts1.getItem().getName());
            order.setStatus("Pending");
            order.setUser(carts1.getUser());
            order.setQuantity(carts1.getQuantity());
            order.setItem(carts1.getItem());
            order.setPrice(carts1.getItem().getPrice());
            order.setTotalAmount(carts1.getItem().getPrice()*carts1.getQuantity());
            orders.add(order);
        });
        if (user != null) {
            return orders;
        }
        return null;
    }
}