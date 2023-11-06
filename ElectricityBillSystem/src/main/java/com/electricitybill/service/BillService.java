package com.electricitybill.service;

import java.util.List;

import com.electricitybill.entity.Bill;
import com.electricitybill.model.BillDTO;

public interface BillService {
	BillDTO createBill(Bill bill);
	
	List<BillDTO> getAllBill();
	
	BillDTO getBillById(int id);
	
	BillDTO updateById(int id, Bill bill);
	
	String deleteById(int id);
	
	
}
