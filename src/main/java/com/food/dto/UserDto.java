package com.food.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer userId;
    private String name;
    private String username;
    private String mobile;
    private String email;
    private String address;
    private String postcode;
    private String imageUrl;
}
