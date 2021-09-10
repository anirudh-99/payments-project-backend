package com.dbs.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bank_bic")
public class BankBic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bic",length = 20)
	String bic;

	@Column(name = "name")
	@NotNull
	String name;

	public BankBic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankBic(String bic, String name) {
		super();
		this.bic = bic;
		this.name = name;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BankBic [bic=" + bic + ", name=" + name + "]";
	}

}
