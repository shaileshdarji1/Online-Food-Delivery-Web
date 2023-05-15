package com.food.services;

import com.food.entity.User;

public interface UserService {
    public User createUser(User user);
    public boolean checkUsername(String username);

    public User getUser(Integer userId);
}
