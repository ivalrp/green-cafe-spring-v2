package com.green.cafee.springboot.v2.model;

import com.green.cafee.springboot.v2.model.base.CrudBase;
import com.green.cafee.springboot.v2.model.base.SecureId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_position")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition extends SecureId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "salary", nullable = false)
    private Double salary;
}
