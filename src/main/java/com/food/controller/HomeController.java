package com.food.controller;

import com.food.entity.User;
import com.food.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUse(@ModelAttribute User user, ModelMap model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(userService.checkUsername(user.getUsername())){
            model.addAttribute("error","Username Already Exits");
            return "/signup";
        }
        else {
            User usr = userService.createUser(user);
            if (usr != null) {
                model.addAttribute("success","User Register Successfully");
            } else {
                model.addAttribute("error","Something went wrong in server");
                return "/signup";
            }
        }
        return "redirect:/login";
    }


}
