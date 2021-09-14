package com.dbs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.data.entities.Transaction;
import com.dbs.dto.TransactionHistoryRequestDto;
import com.dbs.dto.TransactionHistoryResponseDto;
import com.dbs.dto.TransactionRequestDto;
import com.dbs.services.TransactionService;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping()
	public ResponseEntity<Transaction> processTransaction(@RequestBody TransactionRequestDto transactionDto) {
		Transaction trans = transactionService.saveTransaction(transactionDto);
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}

	// used for retrieving transaction history
	@PostMapping("/history")
	public ResponseEntity<TransactionHistoryResponseDto> getTransactions(
			@RequestBody TransactionHistoryRequestDto transDto, @RequestParam("page") int page,
			@RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
		Page<Transaction> transactionsPage = transactionService.getTransactionsBetween(transDto.getStartDate(),
				transDto.getEndDate(), page, limit);

		return new ResponseEntity<>(
				new TransactionHistoryResponseDto(transactionsPage.getTotalElements(), transactionsPage.getContent()),
				HttpStatus.OK);
	}

}
