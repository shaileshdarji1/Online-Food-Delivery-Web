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
public class User {

    @Id
    @SequenceGenerator(
            name = "userid_sequence",
            sequenceName = "userid_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userid_sequence"
    )
    private int userId;
    private String name;
    @Column(
            unique = true
    )
    private String username;
    private String mobile;
    private String email;
    private String address;
    private String postcode;
    private String password;
    private String imageUrl;
    private Date date;
}
