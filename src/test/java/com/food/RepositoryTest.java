package com.food;

import com.food.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    UserRepository userRepository;

   @Test
   public void userData(){
       System.out.println(userRepository.findByUsername("Haresh"));
   }
}
