package com.food.services;

import com.food.entity.Carts;

import java.util.List;


public interface CartService {

    public void saveProduct(Carts carts);

    public List<Carts> findCartProduct();
}