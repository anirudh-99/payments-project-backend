package com.dbs.dto;

import java.util.Date;

public class TransactionHistoryRequestDto {
	String startDate;
	String endDate;
	public TransactionHistoryRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionHistoryRequestDto(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "TransactionHistoryRequestDto [startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	

}
