package com.green.cafee.springboot.v2.repository;

import com.green.cafee.springboot.v2.model.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {

}
