package com.food.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class OrdersDto {
    private String orderName;
    private Integer quantity;
    private String status = "pending";
    private Integer itemId;
    private Integer userId;
    private Integer price;
    private Integer totalAmount;
}
