package com.roiim.roiim.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roiim.roiim.model.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
