package com.dbs.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.data.entities.Customer;
import com.dbs.exceptions.ResourceNotFoundException;
import com.dbs.repo.CustomerRepo;
import com.dbs.utils.TopCustomer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	public Customer getCustomerByAcctNumber(String acctNo) {
		return customerRepo.findById(acctNo)
				.orElseThrow(() -> new ResourceNotFoundException("The given account number doesn't exists"));
	}

	@SuppressWarnings("unchecked")
	public List<TopCustomer> getTopCustomersByRemittance() {
		List<TopCustomer> custs = (List<TopCustomer>) customerRepo.getTopCustomersByRemittance();

		if (custs == null) {
			throw new ResourceNotFoundException("We are unable to fetch the top customers");
		}
		return custs;
	}
}
