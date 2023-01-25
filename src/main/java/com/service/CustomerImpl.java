package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;
import com.exception.BankApplicationException;
import com.repository.AccountRepo;
import com.repository.BankAdminRepo;
import com.repository.CustomerRepo;
@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private BankAdminRepo bankAdminRepo;
	@Autowired 
	private AccountRepo accountRepo;
	
	@Override
	public String deposit(long accNo, float amount) throws BankApplicationException {
		   Account account=accountRepo.findByAccNo(accNo);
		   String messege="";
		   if(account.getAccNo()==accNo) {
			      float accBal=account.getBalance()+amount;
			      account.setBalance(accBal);
			      accountRepo.save(account);
			      messege="Your amount has been deposited Successfully";
		   }
		   else {
			   throw new BankApplicationException("Account Number is Not found");
		   }
		   
		   
		return messege;
	}

	@Override
	public String withdrawl(long accNo, float amount) throws BankApplicationException {
		 Account account=accountRepo.findByAccNo(accNo);
		   String messege="";
		   if(account.getAccNo()==accNo) {
			      float accBal=account.getBalance()-amount;
			      account.setBalance(accBal);
			      accountRepo.save(account);
			      messege="Your amount has been withdrawl Successfully";
		   }
		   else {
			   throw new BankApplicationException("Account Number is Not found");
		   }
		   
		   
		return messege;
	}

	@Override
	public float CheckBalance(long accNo) throws BankApplicationException {
		Account account=accountRepo.findByAccNo(accNo);
		float check=0;
		if(account.getAccNo()==accNo) {
			check=account.getBalance();
		}
		else {
			throw new BankApplicationException("You have entered Wrong Account Number");
		}
		return check;
	}
	

	
}
