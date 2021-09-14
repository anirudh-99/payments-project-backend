package com.dbs.dto;

import java.util.List;

import com.dbs.data.entities.Transaction;

public class TransactionHistoryResponseDto {
	long totalElements;
	List<Transaction> items;
	public TransactionHistoryResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionHistoryResponseDto(long totalElements, List<Transaction> items) {
		super();
		this.totalElements = totalElements;
		this.items = items;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public List<Transaction> getItems() {
		return items;
	}
	public void setItems(List<Transaction> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "TransactionHistoryResponseDto [totalElements=" + totalElements + ", items=" + items + "]";
	}
	
}
