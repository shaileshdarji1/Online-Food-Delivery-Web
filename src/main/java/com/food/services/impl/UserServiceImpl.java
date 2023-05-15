package com.food.services.impl;

import com.food.entity.User;
import com.food.repository.UserRepository;
import com.food.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean checkUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findUser(userId);
    }
}
