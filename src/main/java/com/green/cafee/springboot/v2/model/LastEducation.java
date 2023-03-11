package com.green.cafee.springboot.v2.model;

import com.green.cafee.springboot.v2.model.base.CreatedBase;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "last_education")
public class LastEducation extends CreatedBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
