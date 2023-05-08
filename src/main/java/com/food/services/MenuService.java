package com.food.services;

import com.food.entity.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> findAllMenu();
    public Menu saveMenu(Menu menu);
}
