package com.dbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.data.entities.MessageCode;
import com.dbs.exceptions.ResourceNotFoundException;
import com.dbs.repo.MessageCodeRepo;

@Service
public class MessageCodesService {
	
	@Autowired
	MessageCodeRepo msgCodeRepo;
	
	public List<MessageCode>getAllMessageCodes(){
		return msgCodeRepo.findAll();
	}
	
	public MessageCode findById(String msgCode) {
		return msgCodeRepo.findById(msgCode)
				.orElseThrow(() -> new ResourceNotFoundException("The given message code doesn't exists"));
	}
	
}
