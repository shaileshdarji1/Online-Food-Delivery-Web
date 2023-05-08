package com.food.controller;

import com.food.entity.Menu;
import com.food.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "admin";
    }

    @RequestMapping("/category")
    public String category(){
        return "category";
    }

    @PostMapping("/add_category")
    public String addCategory(@ModelAttribute Menu menu, ModelMap model){
        Date date =Date.valueOf(LocalDate.now());
        menu.setCreatedDate(date);
        if(menu!=null){
          menuService.saveMenu(menu);
          model.addAttribute("success","Menu Added sucessfully");
        }
        else
        {
         model.addAttribute("error","Something went to wrong");
        }
        return "redirect:/admin/category";
    }
}
