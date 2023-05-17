package com.food.controller;

import com.food.config.CustomUserDetails;
import com.food.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/")
    public String home(){

        User user =
        return "index";
    }

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }
}
