package com.food.dto;

import com.food.entity.Item;
import com.food.entity.User;
import lombok.Data;

@Data
public class CartDto {
    private Integer quantity;
    private Integer item_id;
    private Integer user_id;
}
