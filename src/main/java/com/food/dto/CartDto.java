package com.food.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CartDto {
    private Integer quantity;
    private Integer itemId;

}