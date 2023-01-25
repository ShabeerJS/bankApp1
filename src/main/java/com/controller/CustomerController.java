package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.BankApplicationException;
import com.service.CustomerService;


@RestController
@RequestMapping(value = "customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@PutMapping(value = "deposit/{accNo}/{amount}")
	public String deposit(@PathVariable long accNo,@PathVariable float amount) throws BankApplicationException {
		return customerService.deposit(accNo, amount);
		
	}
	
	@PutMapping(value = "withdrawl/{accNo}/{amount}")
	public String withdrawl(long accNo, float amount) throws BankApplicationException{
		return customerService.withdrawl(accNo, amount);
		
	}
	
	@GetMapping(value = "balance/{accNo}")
	public float CheckBalance(@PathVariable long accNo) throws BankApplicationException{
		return customerService.CheckBalance(accNo);
	}
}
