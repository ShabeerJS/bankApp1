package com.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
public class Transaction {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
	  private int transId;
      @Column
	  private String transType;
      @Column
	  private float amount;
      @Column
	  private LocalDate localDate;
      @Column
	  private LocalTime localTime;
	  
	
      @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @JoinColumn(name = "accId",referencedColumnName = "accId")
	  @JsonBackReference(value = "transactionAccount")
	  private Account account;


	public Transaction() {
		super();
	}


	public Transaction(int transId, String transType, float amount, LocalDate localDate, LocalTime localTime,
			Account account) {
		super();
		this.transId = transId;
		this.transType = transType;
		this.amount = amount;
		this.localDate = localDate;
		this.localTime = localTime;
		this.account = account;
	}


	public int getTransId() {
		return transId;
	}


	public void setTransId(int transId) {
		this.transId = transId;
	}


	public String getTransType() {
		return transType;
	}


	public void setTransType(String transType) {
		this.transType = transType;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public LocalDate getLocalDate() {
		return localDate;
	}


	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}


	public LocalTime getLocalTime() {
		return localTime;
	}


	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
      
      
      
      
	  
}
