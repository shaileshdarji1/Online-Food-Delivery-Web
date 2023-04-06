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
public class Payment {

    @Id
    @SequenceGenerator(
            name="paymentid_sequence",
            sequenceName = "paymentid_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paymentid_sequence"
    )
    private int paymentId;
    private String name;
    private String cardNo;
    private String expireDate;
    private int cvvNo;
    private String address;
    private String paymentMode;

}
