package com.food.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String orderName;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(
            name="user_id",
            referencedColumnName = "userId"
    )
    private User user;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="item_id",
            referencedColumnName = "itemId"
    )
    private Item item;
    private Float price;
    private Float totalAmount;

    public Orders(String name, Integer quantity, User user, Item item, Float price) {
        this.orderName=name;
        this.quantity = quantity;
        this.user= user;
        this.item=item;
        this.price=price;
        this.totalAmount=price*quantity;
    }
}