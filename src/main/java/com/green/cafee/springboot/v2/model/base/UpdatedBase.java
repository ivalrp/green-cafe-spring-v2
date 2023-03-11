package com.green.cafee.springboot.v2.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@MappedSuperclass
public class UpdatedBase extends CreatedBase implements Serializable {
    private static final long serialVersionUID = 2074807138718240105L;

    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDate updatedAt;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

}
