package com.food.services.impl;

import com.food.config.CustomUserDetails;
import com.food.dto.UserDto;
import com.food.entity.User;
import com.food.repository.UserRepository;
import com.food.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean checkUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDto getCurrentlyLoggedInUser(Authentication authentication) {
        if (authentication == null) return null;
        User user = null;
        UserDto userDto;
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails)
            user = ((CustomUserDetails) principal).getUser();
        userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
