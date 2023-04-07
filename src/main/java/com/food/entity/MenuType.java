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
public class MenuType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int menutypeId;
    private String name;
    private String description;
    private float price;
    private int quality;
    private String imageUrl;
    private boolean isActive;
    private Date createdDate;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "menu_id",
            referencedColumnName = "menuId"
    )
    private Menu menu;

}
