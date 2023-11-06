package com.electricitybill.service;

import com.electricitybill.entity.Customer;
import com.electricitybill.model.CustomerDTO;

public interface CustomerService {
	CustomerDTO registerCustomer(Customer customer);
	
	String assignBillToCustomer(int cust_id, int id);
	
	
}
