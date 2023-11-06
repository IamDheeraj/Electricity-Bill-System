package com.electricitybill.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electricitybill.entity.Bill;
import com.electricitybill.exception.ResourceNotFoundException;
import com.electricitybill.model.BillDTO;
import com.electricitybill.repository.BillRepo;
import com.electricitybill.service.BillService;
import com.electricitybill.utility.Converter;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillRepo billrepo;
	
	@Autowired
	private Converter converter;

	@Override
	public BillDTO createBill(Bill bill) {
		Bill bill2 = billrepo.save(bill);
		return converter.convertToDTO(bill2);
	}

	@Override
	public List<BillDTO> getAllBill() {
		List<Bill> bill3 = billrepo.findAll();
		List<BillDTO> listdto = new ArrayList<>();
		
		for (Bill bill : bill3) {
			listdto.add(converter.convertToDTO(bill));
		}
		return listdto;
	}

	@Override
	public BillDTO getBillById(int id) {
		Bill bill = billrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Bill", " id " , id));
		return converter.convertToDTO(bill);
	}

	@Override
	public BillDTO updateById(int id, Bill bill) {
	 
		Bill bill1 = billrepo.findById(id).get();
		bill1.setNum(bill.getNum());
		bill1.setAmount(bill.getAmount());
		
		Bill bill2 =  billrepo.save(bill1);
	    
		return converter.convertToDTO(bill2);
	}

	@Override
	public String deleteById(int id) {
		billrepo.deleteById(id);
		return "student deleted id " + id ;
	}
	
	
	
	
	
	
	
	
	
	
	
}
