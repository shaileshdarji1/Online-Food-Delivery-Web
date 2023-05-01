package com.food.controller;

import com.food.entity.Menu;
import com.food.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class MenuController {
     @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Menu> allCategory(){
       return menuService.findAllMenu();
    }
}
