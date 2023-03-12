package com.green.cafee.springboot.v2.model;

import com.green.cafee.springboot.v2.model.base.SecureId;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
@Data
public class AppUser extends SecureId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile_phone", nullable = false)
    private String mobilePhone;

    @Column(name = "address", nullable = false)
    private String address;
}
