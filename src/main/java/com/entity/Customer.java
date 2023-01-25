package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
public class Customer {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
    @Column
	private String customerName;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column
	private int age;
    @Column 
	private String gender;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customer")
    @JsonManagedReference(value = "customerAccount")
    private Account account;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "adminId",referencedColumnName = "adminId")
    @JsonBackReference(value = "adminCustomer")
    private BankAdmin bankAdmin;
    
    
    public Customer() {
		super();
	}


	public Customer(int customerId, String customerName, int age, String gender, Account account, BankAdmin bankAdmin) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.age = age;
		this.gender = gender;
		this.account = account;
		this.bankAdmin = bankAdmin;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public BankAdmin getBankAdmin() {
		return bankAdmin;
	}


	public void setBankAdmin(BankAdmin bankAdmin) {
		this.bankAdmin = bankAdmin;
	}
    

	
    
    
	
	
}
