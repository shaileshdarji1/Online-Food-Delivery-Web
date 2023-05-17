package com.food.services;

import com.food.dto.UserDto;
import com.food.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    public User createUser(User user);
    public boolean checkUsername(String username);
    public UserDto getCurrentlyLoggedInUser(Authentication authentication);
}
