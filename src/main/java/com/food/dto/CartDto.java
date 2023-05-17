package com.food.dto;

import lombok.Data;

@Data
public class CartDto {
    private Integer quantity;
    private Integer item_id;
    private Integer user_id;

}