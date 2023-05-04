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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @Column(
            unique = true
    )
    private String orderName;
    private int quality;
    private String status;
    private Date createdDate;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="user_id",
            referencedColumnName = "userId"
    )
    private Users users;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="menutype_id",
            referencedColumnName = "menutypeId"
    )
    private MenuType menuType;
}
