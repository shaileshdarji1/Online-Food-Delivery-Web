package com.food.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer contactId;
    private String name;
    private String email;
    private String  subject;
    private String message;
    private Date createdDate;
}
