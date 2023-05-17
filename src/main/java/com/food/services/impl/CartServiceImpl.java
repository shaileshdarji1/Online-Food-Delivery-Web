package com.food.services.impl;

import com.food.entity.Carts;
import com.food.repository.CartRepository;
import com.food.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public void saveProduct(Carts carts) {
        cartRepository.save(carts);
    }

    @Override
    public List<Carts> findCartProduct() {
        return cartRepository.findAll();
    }
}