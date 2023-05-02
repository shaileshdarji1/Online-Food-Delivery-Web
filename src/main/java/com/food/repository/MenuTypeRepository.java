package com.food.repository;

import com.food.entity.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuTypeRepository extends JpaRepository<MenuType,Integer>{
}
