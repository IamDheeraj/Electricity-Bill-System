package com.electricitybill.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(unique = true)
	private String num;
	
	@Column(length = 7)
	private int amount;
	
	private boolean status = Boolean.TRUE;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cust_id")
	@JsonIgnoreProperties("bill")
	private Customer customer;
}
