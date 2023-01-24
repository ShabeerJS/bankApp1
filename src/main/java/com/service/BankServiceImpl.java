package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BankAdmin;
import com.entity.Customer;
import com.repository.BankAdminRepo;
import com.repository.CustomerRepo;

@Service
public class BankServiceImpl implements BankAdminService {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private BankAdminRepo bankAdminRepo;
	
	
	@Override
	public BankAdmin addBankAdmin(BankAdmin bankAdmin) {
		
		return bankAdminRepo.save(bankAdmin);
	}

	@Override
	public Customer addCustomer(Customer customer,int adminId) {
               BankAdmin bankAdmin=  bankAdminRepo.findById(adminId).get();
               System.out.println(bankAdmin.getAdminMail());
               customer.setBankAdmin(bankAdmin);
               
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(int custId) {
		   Customer customer= customerRepo.findById(custId).get();
		return customer;
	}

	@Override
	public BankAdmin getAdminById(int adminId) {
	                         BankAdmin admin=       bankAdminRepo.findById(adminId).get();
		return admin;
	}
	

	

}
