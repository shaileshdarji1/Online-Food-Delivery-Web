package com.food.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class ItemDto {
    private String name;
    private String description;
    private Float price;
    private Integer quality;
    private String imageUrl;
    private boolean isActive;
    private Integer categoryId;
}
