package com.dbs.utils;

public class TopCustomer {

	String name;
	Double amount;

	public TopCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopCustomer(String name, Double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TopCustomer [name=" + name + ", amount=" + amount + "]";
	}

}
