package com.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carts {

    @Id
    @SequenceGenerator(
            name = "cartid_sequence",
            sequenceName ="cartid_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cartid_sequence"
    )
    private int cartId;
    private int quality;

}
