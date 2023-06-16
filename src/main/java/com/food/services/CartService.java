package com.food.services;

import com.food.entity.Carts;
import com.food.entity.User;

import java.util.List;


public interface CartService {

    public void saveProduct(Carts carts);

    public List<Carts> findCartProduct();

    public List<Carts> findCartProductByUser(User user);

    public void deleteItemByUser(User user);

    public long count();

    public void deleteCart(Integer cartId);

}