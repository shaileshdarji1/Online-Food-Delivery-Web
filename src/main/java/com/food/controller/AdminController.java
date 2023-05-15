package com.food.controller;

import com.food.dto.ItemDto;
import com.food.entity.Category;
import com.food.entity.Item;
import com.food.services.CategoryService;
import com.food.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ItemService itemService;

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "admin";
    }

    @RequestMapping("/category")
    public String category() {
        return "category";
    }

    @RequestMapping("/item")
    public String item() {
        return "item";
    }

    @PostMapping("/add_category")
    public String addCategory(@ModelAttribute Category category) {
        Date date = Date.valueOf(LocalDate.now());
        category.setCreatedDate(date);
        if (category != null) {
            categoryService.saveCategory(category);
        }
        return "redirect:/admin/category";
    }

    @PostMapping("/add_item")
    public String saveItem(@ModelAttribute ItemDto itemDto) {

        Item item = modelMapper.map(itemDto, Item.class);
        item.setCategory(categoryService.findCategoryById(itemDto.getCategoryId()));
        Date date = Date.valueOf(LocalDate.now());
        item.setCreatedDate(date);
        itemService.saveItem(item);
        return "redirect:/admin/item";
    }
}
