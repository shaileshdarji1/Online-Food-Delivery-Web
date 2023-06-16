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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;
    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("/")
    public List<Orders> findAllOrder(){
        return orderService.findAllOrder();
    }
    @RequestMapping("/show")
    @ResponseBody
    public List<Orders> showOrders() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.getCurrentlyLoggedInUser(auth);
        User user = modelMapper.map(userDto, User.class);
        return orderService.showOrders(user);
    }

    @RequestMapping("/add_order")
    public void addOrder() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.getCurrentlyLoggedInUser(auth);
        User user = modelMapper.map(userDto, User.class);
        List<Carts> carts = cartService.findCartProductByUser(user);
        List<Orders> orders =orderService.getOrderfromCart(carts);
        if (user != null) {
            orderService.addOrder(orders);
            cartService.deleteItemByUser(user);
        }
    }
}