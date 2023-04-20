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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String role="User";
    private Date date;
}
