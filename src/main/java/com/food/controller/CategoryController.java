package com.food.controller;

import com.food.dto.ItemDto;
import com.food.entity.Category;
import com.food.entity.Item;
import com.food.services.CategoryService;
import com.food.services.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    CategoryService categoryService;


    @GetMapping("/")
    public List<Category> allCategory() {
        return categoryService.findAllCategory();
    }



    @PostMapping("/delete/{category_id}")
    public void deleteCategory(@PathVariable("category_id") Integer category_id) {
        categoryService.deleteCategory(category_id);
    }

}
