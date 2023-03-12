package com.green.cafee.springboot.v2.model.base;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
public class SecureId extends CrudBase implements Serializable {
    private static final long serialVersionUID = 2074807138718240105L;

    @Column(name = "secure_id", nullable = false, unique = true)
    private String secureId = UUID.randomUUID().toString();



}
