package com.dbs.dto;

public class TransactionRequestDto {
	String transferType;
	String messageCode;
	Double amount;
	String receiverAcctNumber;
	String receiverName;
	String senderAcctNumber;
	String receiverBic;

	public TransactionRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionRequestDto(String transferType, String message_code, Double amount, String receiverAcctNumber,
			String receiverName, String senderAcctNumber, String receiverBic) {
		super();
		this.transferType = transferType;
		this.messageCode = message_code;
		this.amount = amount;
		this.receiverAcctNumber = receiverAcctNumber;
		this.receiverName = receiverName;
		this.senderAcctNumber = senderAcctNumber;
		this.receiverBic = receiverBic;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String message_code) {
		this.messageCode = message_code;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getReceiverAcctNumber() {
		return receiverAcctNumber;
	}

	public void setReceiverAcctNumber(String receiverAcctNumber) {
		this.receiverAcctNumber = receiverAcctNumber;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSenderAcctNumber() {
		return senderAcctNumber;
	}

	public void setSenderAcctNumber(String senderAcctNumber) {
		this.senderAcctNumber = senderAcctNumber;
	}

	public String getReceiverBic() {
		return receiverBic;
	}

	public void setReceiverBic(String receiverBic) {
		this.receiverBic = receiverBic;
	}

	@Override
	public String toString() {
		return "TransactionRequestDto [transferType=" + transferType + ", messageCode=" + messageCode + ", amount="
				+ amount + ", receiverAcctNumber=" + receiverAcctNumber + ", receiverName=" + receiverName
				+ ", senderAcctNumber=" + senderAcctNumber + ", receiverBic=" + receiverBic + "]";
	}

}
