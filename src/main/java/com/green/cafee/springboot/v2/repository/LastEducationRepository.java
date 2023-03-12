package com.green.cafee.springboot.v2.repository;

import com.green.cafee.springboot.v2.model.LastEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LastEducationRepository extends JpaRepository<LastEducation, Long> {

    public Optional<LastEducation> findBySecureId(String secureId);

}
