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
public class Menu {

    @Id
    @SequenceGenerator(
            name = "menu_sequence",
            sequenceName = "menu_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menu_sequence"

    )
    private int menuId;
    private String name;
    private String imageUrl;
    private boolean isActive;
    private Date createdDate;
}
