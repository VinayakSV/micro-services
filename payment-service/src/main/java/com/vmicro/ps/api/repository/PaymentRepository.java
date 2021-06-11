package com.vmicro.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmicro.ps.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
