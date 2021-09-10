package com.dbs.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "message_code")
public class MessageCode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "message_code",length=20)
	String messageCode;
	
	@Column(name = "description")
	@NotNull
	String description;

	public MessageCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageCode(String messageCode, String description) {
		super();
		this.messageCode = messageCode;
		this.description = description;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MessageCode [messageCode=" + messageCode + ", description=" + description + "]";
	}
	
	
	
}
