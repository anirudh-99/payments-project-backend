package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.data.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, String> {

}
