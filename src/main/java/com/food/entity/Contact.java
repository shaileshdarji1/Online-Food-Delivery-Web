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
public class Contact {

    @Id
    @SequenceGenerator(
            name = "contactid_sequence",
            sequenceName ="contactid_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contactid_sequence"
    )
    private  int contactId;
    private String name;
    private String email;
    private String  subject;
    private String message;
    private Date createdDate;
}
