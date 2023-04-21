package com.food.repository;

import com.food.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
   public boolean existsByUsername(String username);
   public User findByUsername(String username);
}
