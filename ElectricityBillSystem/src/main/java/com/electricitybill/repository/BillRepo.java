package com.electricitybill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electricitybill.entity.Bill;

public interface BillRepo extends JpaRepository<Bill, Integer> {
	
}
