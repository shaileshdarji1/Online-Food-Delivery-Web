package com.food;

import com.food.repository.CategoryRepository;
import com.food.repository.OrderRepository;
import com.food.repository.UserRepository;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;
   @Test
   public void userData(){
       System.out.println(userRepository.findByUsername("Haresh"));
   }


   @Test
    public void findOrderByUser(){
       System.out.println(orderRepository.showOrders(1));
   }
}
