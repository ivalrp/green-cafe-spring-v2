package com.green.cafee.springboot.v2.repository;

import com.green.cafee.springboot.v2.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

}
