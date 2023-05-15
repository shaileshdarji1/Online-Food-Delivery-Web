package com.food.controller;

import com.food.dto.CartDto;
import com.food.entity.Carts;
import com.food.services.CartService;
import com.food.services.ItemService;
import com.food.services.UserService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("/")
    @ResponseBody
    public List<Carts> findCartProduct(){
        return cartService.findCartProduct();
    }

    @PostMapping("/add_cart")
    public String saveCart(@RequestBody CartDto cartDto){
        if(cartDto != null){
            Carts carts = modelMapper.map(cartDto,Carts.class);
            carts.setItem(itemService.getItem(cartDto.getItem_id()));
            carts.setUser(userService.getUser(cartDto.getUser_id()));
            cartService.saveProduct(carts);
            return "Success";
        }
        return "Failed";
    }
}
