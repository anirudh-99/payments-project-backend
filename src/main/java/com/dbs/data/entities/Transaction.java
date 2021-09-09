package com.dbs.data.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dbs.utils.TransferType;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id", length = 20)
	Long transactionId;

	@Column(name = "amount")
	Double amount;

	@Column(name = "receiver_account_number")
	String receiverAccountNumber;

	@Column(name = "receiver_name")
	String receiverName;

	@ManyToOne()
	@JoinColumn(name = "account_number")
	Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_code")
	MessageCode messageCode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "receiver_bic",referencedColumnName = "bic")
	BankBic receiverBic;
	
	@Column(name = "transfer_type",length=10)
	@Enumerated(EnumType.STRING)
	TransferType transferType;

	@Temporal(TemporalType.TIMESTAMP)
	Date timestamp;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long transactionId, Double amount, String receiverAccountNumber, String receiverName,
			Customer customer, MessageCode messageCode, BankBic receiverBic) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.receiverAccountNumber = receiverAccountNumber;
		this.receiverName = receiverName;
		this.customer = customer;
		this.messageCode = messageCode;
		this.receiverBic = receiverBic;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(String receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public MessageCode getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(MessageCode messageCode) {
		this.messageCode = messageCode;
	}

	public BankBic getReceiverBic() {
		return receiverBic;
	}

	public void setReceiverBic(BankBic receiverBic) {
		this.receiverBic = receiverBic;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", receiverAccountNumber="
				+ receiverAccountNumber + ", receiverName=" + receiverName + ", customer=" + customer + ", messageCode="
				+ messageCode + ", receiverBic=" + receiverBic + ", timestamp=" + timestamp + "]";
	}

}
