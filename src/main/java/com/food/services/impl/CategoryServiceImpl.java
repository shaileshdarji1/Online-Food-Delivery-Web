package com.food.services.impl;

import com.food.entity.Category;
import com.food.repository.CategoryRepository;
import com.food.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(Integer menu_id) {
        return categoryRepository.findCategory(menu_id);
    }

    @Override
    public void deleteCategory(Integer category_id) {
        Category category= categoryRepository.findCategory(category_id);
        categoryRepository.delete(category);
    }
}
