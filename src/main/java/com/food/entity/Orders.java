package com.food.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(
            unique = true
    )
    private String orderName;
    private Integer quality;
    private String status;
    private Date createdDate;

    @ManyToOne(
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;

    @ManyToOne()
    @JoinColumn(
            name = "item_id",
            referencedColumnName = "itemId"
    )
    private Item item;
}
