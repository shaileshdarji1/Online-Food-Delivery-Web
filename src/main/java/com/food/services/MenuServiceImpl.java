package com.food.services;

import com.food.entity.Menu;
import com.food.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuRepository menuRepository;
    @Override
    public List<Menu> findAllMenu() {
        return menuRepository.findAll();
    }
}
