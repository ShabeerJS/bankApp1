package com.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
public class Account {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
      private int accId;
	 @Column
	  private String bankName;
	 @Column (unique = true,length = 12)
	  private long accNo;
	 @Column
	  private float balance;
	 @Column
	  private String ifscCode;
	 @Column
	  private String branch;
	 
	 
	 @OneToOne
	 @JoinColumn(name = "customerId",referencedColumnName = "customerId")
	 @JsonBackReference(value = "customerAccount")
	 private Customer customer;
	 
	 @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "account")
	 @JsonManagedReference(value = "transactionAccount")
	 private List<Transaction> transactions;

	public Account() {
		super();
	}

	public Account(int accId, String bankName, long accNo, float balance, String ifscCode, String branch,
			Customer customer, List<Transaction> transactions) {
		super();
		this.accId = accId;
		this.bankName = bankName;
		this.accNo = accNo;
		this.balance = balance;
		this.ifscCode = ifscCode;
		this.branch = branch;
		this.customer = customer;
		this.transactions = transactions;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	 
	 
	  
}
