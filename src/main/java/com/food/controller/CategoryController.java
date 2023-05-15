package com.food.controller;

import com.food.entity.Category;
import com.food.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
