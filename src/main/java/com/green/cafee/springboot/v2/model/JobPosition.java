package com.green.cafee.springboot.v2.model;

import com.green.cafee.springboot.v2.model.base.CreatedBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_position")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition extends CreatedBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "salary", nullable = false)
    private Double salary;
}
