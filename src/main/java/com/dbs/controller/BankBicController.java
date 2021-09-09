package com.dbs.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbs.data.entities.BankBic;
import com.dbs.services.BankBicService;

@Controller
@RequestMapping("/bankbic")
@CrossOrigin(origins = "http://localhost:4200")
public class BankBicController {

	@Autowired
	BankBicService bankBicService;

	@GetMapping("{bic}")
	public ResponseEntity<BankBic> getBankDetailsByBic(@PathVariable("bic") String bic) {
		BankBic bank = bankBicService.getBankDetailsByBic(bic);

		return new ResponseEntity<>(bank, HttpStatus.OK);
	}

}
