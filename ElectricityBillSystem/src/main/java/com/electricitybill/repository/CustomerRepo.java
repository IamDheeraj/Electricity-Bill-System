package com.electricitybill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electricitybill.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
}
