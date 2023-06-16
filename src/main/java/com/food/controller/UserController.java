package com.food.controller;

import com.food.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("cart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("/order")
    public String order(){
        return "order";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
}
