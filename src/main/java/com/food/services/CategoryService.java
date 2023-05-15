package com.food.services;

import com.food.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategory();

    public Category saveCategory(Category category);

    public Category findCategoryById(Integer category_id);

    public void deleteCategory(Integer category_id);
}
