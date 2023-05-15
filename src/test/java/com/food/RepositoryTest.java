package com.food;

import com.food.repository.CategoryRepository;
import com.food.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;
   @Test
   public void userData(){
       System.out.println(userRepository.findByUsername("Haresh"));
   }

   @Test
    public void findMenuById(){
       System.out.println(categoryRepository.findMenu(3));
   }
}
