package com.electricitybill.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.electricitybill.entity.Bill;
import com.electricitybill.model.BillDTO;
import com.electricitybill.service.BillService;
import com.electricitybill.utility.Converter;

@RestController
@RequestMapping("/api")
public class BillControl {
	
	@Autowired
	private BillService billService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createbill")
	ResponseEntity<BillDTO> createBill(@Valid @RequestBody BillDTO billDTO) {
		
		final Bill bill = converter.convertToEntity(billDTO);
		return new ResponseEntity<BillDTO>(billService.createBill(bill), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getbyid/{id}")
	BillDTO getBillById(@PathVariable("id") int id) {
		return billService.getBillById(id);
	}
	
	@PutMapping("/updatebyid/{id}")
	BillDTO updateBill(@Valid @PathVariable("id") int id, @RequestBody BillDTO billDTO) {
		final Bill bill4 = converter.convertToEntity(billDTO);
		return billService.updateById(id, bill4);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	String deletebyid(@PathVariable("id") int id) {
		return billService.deleteById(id);
		
	}
}
