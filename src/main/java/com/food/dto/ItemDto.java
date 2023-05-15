package com.food.dto;

import lombok.Data;

@Data
public class ItemDto {
    private String name;
    private String description;
    private Float price;
    private Integer quality;
    private boolean isActive;
    private Integer categoryId;
}
