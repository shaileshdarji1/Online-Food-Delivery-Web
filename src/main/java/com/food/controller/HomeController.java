package com.food.controller;

import com.food.entity.User;
import com.food.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUse(@ModelAttribute User user) {

        User usr = userService.createUser(user);
        if(usr != null){
            System.out.println("Register Successfully");
        }
        else{
            System.out.println("Something went wrong in server");
        }
        return "redirect:/signup";
    }

    @GetMapping("/do_login")
    public String loginUser(@ModelAttribute User user){
        System.out.println(user);
        return "index";
    }


}
