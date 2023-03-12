package com.green.cafee.springboot.v2.model.base;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table( indexes = {
        @Index(name = "uk_secure_id", columnList = "secure_id")
})
@Data
@MappedSuperclass
public class CrudBase implements Serializable {
    private static final long serialVersionUID = -6630995400242970025L;

    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime    createdAt;

}