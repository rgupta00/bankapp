package com.bankapp.model.persistance.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="account_table")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private Double balance;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String phone;
	
	@Column(nullable=false)
	private String accountType;//Saving/current
	
	public Account() {}
	



	public Account(String name, Double balance, Date dob, String address,
			String email, String phone, String accountType) {
		super();
		this.name = name;
		this.balance = balance;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.accountType = accountType;
	}




	public Double getBalance() {
		return balance;
	}




	public void setBalance(Double balance) {
		this.balance = balance;
	}




	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
}