package com.green.cafee.springboot.v2.model;

import com.green.cafee.springboot.v2.model.base.CrudBase;
import com.green.cafee.springboot.v2.model.base.SecureId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "last_education")
public class LastEducation extends SecureId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
