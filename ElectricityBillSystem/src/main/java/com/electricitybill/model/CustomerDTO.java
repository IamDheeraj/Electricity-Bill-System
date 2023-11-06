package com.electricitybill.model;

import java.util.List;

import com.electricitybill.entity.Bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	private int cust_id;
	private String custName;
	private String custAdderess;
	private String phoneNumber;
	
	private boolean status = Boolean.TRUE;
	
	List<Bill> bill;
}
