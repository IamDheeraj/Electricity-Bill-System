package com.electricitybill.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.electricitybill.entity.Bill;
import com.electricitybill.entity.Customer;
import com.electricitybill.model.BillDTO;
import com.electricitybill.model.CustomerDTO;



@Component
public class Converter {
	
	public Bill convertToEntity(BillDTO billDTO) {
		Bill bill = new Bill();
		if (billDTO != null) {
			BeanUtils.copyProperties(billDTO, bill);
		}
		return bill;
	}
	
	public BillDTO convertToDTO(Bill bill) {
		
		BillDTO billDTO = new BillDTO();
		if (bill != null) {
			BeanUtils.copyProperties(bill, billDTO);
		}
		return billDTO;
	}
	
	
	
//	-----------------------------------------------------------------------------------
	
	
	public Customer convertToCustomerEntity(CustomerDTO customerDTO) { 
		Customer customer = new Customer();
		
		if (customerDTO != null) {
			BeanUtils.copyProperties(customerDTO, customer);
		}
		
		return customer;
	}
	
	public CustomerDTO convertToCustomerDTO(Customer customer) {
		CustomerDTO customerDTO  = new CustomerDTO();
		if (customer != null) {
			BeanUtils.copyProperties(customer, customerDTO);
		}
		return customerDTO;
	}
	
	
}
