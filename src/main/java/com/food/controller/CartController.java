package com.food.controller;

import com.food.dto.CartDto;
import com.food.dto.UserDto;
import com.food.entity.Carts;
import com.food.entity.User;
import com.food.services.CartService;
import com.food.services.ItemService;
import com.food.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CartDto cartDto;


    @RequestMapping("/")
    @ResponseBody
    public List<Carts> findCartProduct() {
        return cartService.findCartProduct();
    }

    @RequestMapping("/usercart")
    @ResponseBody
    public List<Carts> findCardProductByUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.getCurrentlyLoggedInUser(auth);
        User user = modelMapper.map(userDto, User.class);
        return cartService.findCartProductByUser(user);
    }

    @PostMapping("/add_cart/{itemId}/{quantity}")
    public void saveCart(@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer quantity) {
        cartDto.setItemId(itemId);
        cartDto.setQuantity(quantity);
        if (cartDto != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Carts carts = modelMapper.map(cartDto, Carts.class);
            carts.setItem(itemService.getItem(cartDto.getItemId()));
            UserDto userDto = userService.getCurrentlyLoggedInUser(auth);
            User user = modelMapper.map(userDto, User.class);
            carts.setUser(user);
            cartService.saveProduct(carts);

        }
    }

    @PostMapping("/delete/{cart_id}")
    public void deleteCategory(@PathVariable("cart_id") Integer cartId) {
        cartService.deleteCart(cartId);
    }
}