package com.green.cafee.springboot.v2.repository;

import com.green.cafee.springboot.v2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Optional<Employee> findBySecureId(String secureId);
}
