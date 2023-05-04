package com.food.repository;

import com.food.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
   public boolean existsByUsername(String username);
   public Users findByUsername(String username);
}
