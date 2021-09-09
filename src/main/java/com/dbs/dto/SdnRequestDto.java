package com.dbs.dto;

public class SdnRequestDto {
	String custName;

	public SdnRequestDto() {
		super();
	}

	public SdnRequestDto(String custName) {
		super();
		this.custName = custName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

}
