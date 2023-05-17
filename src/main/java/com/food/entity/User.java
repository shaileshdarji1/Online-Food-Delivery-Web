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
    @Basic(fetch = FetchType.LAZY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
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
    private String role = "ROLE_USER";
    private Date date;
}
