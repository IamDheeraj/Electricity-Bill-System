package com.electricitybill.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricitybill.entity.Customer;
import com.electricitybill.model.CustomerDTO;
import com.electricitybill.service.CustomerService;
import com.electricitybill.utility.Converter;

@RestController
@RequestMapping("/api")
public class CustomerControl {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createcustomer")
	ResponseEntity<CustomerDTO> createBill(@Valid @RequestBody CustomerDTO customerDTO) {
		
		final Customer customer = converter.convertToCustomerEntity(customerDTO);
		return new ResponseEntity<CustomerDTO>(customerService.registerCustomer(customer), HttpStatus.CREATED);
	}
	
	@PostMapping("/assign/{cust_id}/{id}")
	public String assignBillToCustomer(@PathVariable("cust_id") int cust_id, @PathVariable("id") int id) {
		return customerService.assignBillToCustomer(cust_id, id);
		
	}
	
	
	
	
	
}
