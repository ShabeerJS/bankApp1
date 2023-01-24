package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class BankAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	@Column
	private String adminName;
	@Column (unique = true)
	private String adminMail;
	private String password;
	
	@OneToMany(cascade  = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "bankAdmin")
	@JsonManagedReference(value = "adminCustomer")
	private List<Customer> customers;

	public BankAdmin() {
		super();
	}

	public BankAdmin(int adminId, String adminName, String adminMail, String password, List<Customer> customers) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminMail = adminMail;
		this.password = password;
		this.customers = customers;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminMail() {
		return adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	
	
}
