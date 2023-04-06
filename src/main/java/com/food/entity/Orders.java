package com.food.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
    @Id
    @SequenceGenerator(
            name="orderid_sequence",
            sequenceName ="orderid_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "orderid_sequence"
    )
    private int orderId;
    @Column(
            unique = true
    )
    private String orderName;
    private int quality;
    private String status;
    private Date createdDate;
}
