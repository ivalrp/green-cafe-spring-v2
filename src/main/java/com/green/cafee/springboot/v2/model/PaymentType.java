package com.green.cafee.springboot.v2.model;

import com.green.cafee.springboot.v2.model.base.CrudBase;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment_type")
@Data
public class PaymentType extends CrudBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;
}
