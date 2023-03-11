package com.green.cafee.springboot.v2.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.Index;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
@Table( indexes = {
        @Index(name = "uk_secure_id", columnList = "secure_id")
})
@Data
@MappedSuperclass
public class CreatedBase implements Serializable {
    private static final long serialVersionUID = -6630995400242970025L;

    @Column(name = "secure_id", nullable = false, unique = true)
    private String secureId = UUID.randomUUID().toString();
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDate createdAt;

}