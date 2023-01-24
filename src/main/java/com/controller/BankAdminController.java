package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.BankAdmin;
import com.entity.Customer;
import com.service.BankAdminService;

@RestController
@RequestMapping(value = "BankAdmin")
public class BankAdminController {
	
	@Autowired
	private BankAdminService bankAdminService;
	
	@PostMapping(value = "addAdmin")
	public ResponseEntity<BankAdmin> addBankAdmin(@RequestBody BankAdmin bankAdmin){
		return new ResponseEntity<BankAdmin>(bankAdminService.addBankAdmin(bankAdmin),HttpStatus.CREATED);
	}
	
	@PostMapping(value = "addCustomer/{adminId}")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer,@PathVariable int adminId){
		
		return new ResponseEntity<Customer>(bankAdminService.addCustomer(customer,adminId), HttpStatus.CREATED);
	}
	
	@GetMapping(value="getCustomer/{custId}")
	public Customer getCustomerById(@PathVariable int custId) {
		return bankAdminService.getCustomerById(custId);
	}
	@GetMapping(value = "getAdmin/{adminId}")
	public BankAdmin getAdminById(@PathVariable int adminId) {
		return bankAdminService.getAdminById(adminId);
		
	}

}
