package com.electricitybill.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricitybill.entity.Bill;
import com.electricitybill.entity.Customer;
import com.electricitybill.exception.ResourceNotFoundException;
import com.electricitybill.model.CustomerDTO;
import com.electricitybill.repository.BillRepo;
import com.electricitybill.repository.CustomerRepo;
import com.electricitybill.service.CustomerService;
import com.electricitybill.utility.Converter;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerrepo;
	
	@Autowired
	private BillRepo billrepo;
	
	@Autowired
	private CustomerRepo custrepo;
	
	@Autowired
	private Converter converter;

	@Override
	public CustomerDTO registerCustomer(Customer customer) {
	
		return converter.convertToCustomerDTO(customerrepo.save(customer));
	}

	@Override
	public String assignBillToCustomer(int cust_id, int id) {
	    
		Bill bill = billrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bill "," id ", id));
		
		Customer customer =  custrepo.findById(cust_id)
		        .orElseThrow(() -> new ResourceNotFoundException("Student ","id ", cust_id));
		
		List<Bill> bill1 = new ArrayList<>();
		bill1.add(bill);
		
		customer.setBill(bill1);
		bill.setCustomer(customer);
		
		custrepo.save(customer);
		
		return "Bill assign to customer successfully.....";
	}
	
}
