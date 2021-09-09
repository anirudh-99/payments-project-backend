package com.dbs.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.data.entities.Customer;
import com.dbs.dto.SdnRequestDto;
import com.dbs.services.CustomerService;
import com.dbs.utils.Permutation;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/{acctNo}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable("acctNo") String acctNo) {
		Customer cust = customerService.getCustomerByAcctNumber(acctNo);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}

	
}
