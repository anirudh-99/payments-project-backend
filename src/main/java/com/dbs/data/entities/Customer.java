package com.dbs.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dbs.utils.Overdraft;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_number", length = 20)
	String accountNumber;

	@Column(name = "name")
	String name;

	@Column(name = "clear_balance")
	Double clearBalance;

	@Column(name = "overdraft", length = 4)
	@Enumerated(EnumType.STRING)
	Overdraft overdraft;

	public Customer() {
		super();
	}

	public Customer(String account_number, String name, Double clearBalance, Overdraft overdraft) {
		super();
		this.accountNumber = account_number;
		this.name = name;
		this.clearBalance = clearBalance;
		this.overdraft = overdraft;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getClearBalance() {
		return clearBalance;
	}

	public void setClearBalance(Double clearBalance) {
		this.clearBalance = clearBalance;
	}

	public Overdraft getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Overdraft overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", name=" + name + ", clearBalance=" + clearBalance
				+ ", overdraft=" + overdraft + "]";
	}

}
