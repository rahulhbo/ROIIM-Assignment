package com.roiim.roiim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roiim.roiim.model.payment.PaymentRequest;

public interface PaymentRepository extends JpaRepository<PaymentRequest,Long>{

}
