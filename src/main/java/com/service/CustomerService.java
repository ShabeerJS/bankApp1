package com.service;

import org.springframework.stereotype.Service;

import com.exception.BankApplicationException;

@Service
public interface CustomerService {

	public abstract String deposit(long accNo,float amount) throws BankApplicationException;
	public abstract String withdrawl(long accNo,float amount) throws BankApplicationException;
	public abstract float CheckBalance(long accNo) throws BankApplicationException;
	
}
