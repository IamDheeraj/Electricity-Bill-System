package com.electricitybill.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cust_id;
	
	@Column(length = 30)
	private String custName;
	
	@Column(length = 100)
	private String custAddress;
	
	@Column(unique = true)
	private String phoneNumber;
	
	private boolean status = Boolean.TRUE;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("customer")
	List<Bill> bill;
	
	
	
}
