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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    private int quality;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private Users users;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "menutype_id",
            referencedColumnName = "menutypeId"
    )
    private MenuType menuType;

}
