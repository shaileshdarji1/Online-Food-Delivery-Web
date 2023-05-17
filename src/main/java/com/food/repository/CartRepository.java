package com.food.repository;

import com.food.entity.Carts;
import com.food.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Carts, Integer> {

}
