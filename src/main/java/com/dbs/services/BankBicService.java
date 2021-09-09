package com.dbs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.data.entities.BankBic;
import com.dbs.exceptions.ResourceNotFoundException;
import com.dbs.repo.BankBicRepo;

@Service
public class BankBicService {

	@Autowired
	private BankBicRepo bankBicRepo;

	public BankBic getBankDetailsByBic(String bic) {
		return bankBicRepo.findById(bic)
				.orElseThrow(() -> new ResourceNotFoundException("The bank with given bic does not exists"));
	}
}
