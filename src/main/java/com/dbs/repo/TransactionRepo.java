package com.dbs.repo;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.data.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, String> {

	
	public Page<Transaction> findByTimestampBetween(Date fromDate,Date toDate,Pageable pageable);
	
}
