package com.food.services;

import com.food.entity.Users;

public interface UserService {
    public Users createUser(Users users);
    public boolean checkUsername(String username);
}
