package com.food.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer quality;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
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

}
