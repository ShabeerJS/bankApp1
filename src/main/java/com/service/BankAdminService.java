package com.service;

import com.entity.BankAdmin;
import com.entity.Customer;
import com.exception.BankApplicationException;

public interface BankAdminService {
	
	
	public abstract BankAdmin addBankAdmin(BankAdmin bankAdmin);
	public abstract Customer addCustomer(Customer customer,int adminId);
	public abstract Customer getCustomerById(int custId);
	public abstract BankAdmin getAdminById(int adminId);
	

}
