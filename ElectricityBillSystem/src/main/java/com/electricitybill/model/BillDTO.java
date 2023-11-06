package com.electricitybill.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.electricitybill.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BillDTO {
	@NotNull
	private int id;
	
	@NotNull
	@Size(min = 1, max = 30, message ="Your name should be minimum 1 character and maximum 30 character...")
	private String num;
	
	@NotNull

	private int amount;
	
	private Customer customer;
	
}
