package com.food.services.impl;

import com.food.entity.Carts;
import com.food.entity.User;
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

    @Override
    public List<Carts> findCartProductByUser(User user) {
        return cartRepository.findAllItemByUser(user);
    }

    @Override
    public void deleteItemByUser(User user) {
       cartRepository.deleteItemByUser(user);
    }

    @Override
    public long count() {
        return cartRepository.count();
    }

    @Override
    public void deleteCart(Integer cartId) {
        cartRepository.delete(cartRepository.findCart(cartId));
    }



}