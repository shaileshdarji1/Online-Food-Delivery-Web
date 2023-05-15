package com.food.services;

import com.food.entity.Category;
import com.food.entity.Item;
import com.food.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    public List<Category> findAllCategory();
    public Category saveCategory(Category category);

    public Category findCategoryById(Integer category_id);

    public void deleteCategory(Integer category_id);
}
