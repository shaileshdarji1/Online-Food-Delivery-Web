package com.food.repository;

import com.food.entity.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Carts, Integer> {

    public List<Carts> findAll();
}