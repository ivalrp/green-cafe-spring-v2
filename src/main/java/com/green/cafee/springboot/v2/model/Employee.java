package com.green.cafee.springboot.v2.model;

import com.green.cafee.springboot.v2.model.base.SecureId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE employee SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false")
public class Employee extends SecureId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "pob", nullable = false)
    private String pob;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile_phone_number", nullable = false)
    private String mobilePhoneNumber;

    @ManyToOne
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPosition jobPositionId;

    @ManyToOne
    @JoinColumn(name = "last_education_id", nullable = false)
    private LastEducation lastEducationId;
}
