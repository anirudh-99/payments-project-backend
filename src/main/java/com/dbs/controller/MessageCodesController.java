package com.dbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.data.entities.MessageCode;
import com.dbs.services.MessageCodesService;

@RestController
@RequestMapping("/msgcodes")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageCodesController {
	
	@Autowired
	MessageCodesService msgCodesService;
	
	@GetMapping()
	public ResponseEntity<List<MessageCode>> getAllMessageCodes(){
		List<MessageCode> msgCodes = msgCodesService.getAllMessageCodes();
		return new ResponseEntity(msgCodes,HttpStatus.OK);
	}
	
}
