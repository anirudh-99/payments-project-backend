package com.dbs.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.data.entities.Customer;
import com.dbs.exceptions.ResourceNotFoundException;
import com.dbs.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public Customer getCustomerByAcctNumber(String acctNo) {
		return customerRepo.findById(acctNo)
				.orElseThrow(() -> new ResourceNotFoundException("The given account number doesn't exists"));
	}
}
