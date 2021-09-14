package com.dbs.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dbs.data.entities.Customer;
import com.dbs.data.entities.Transaction;
import com.dbs.dto.TransactionRequestDto;
import com.dbs.exceptions.TransactionNotValidException;
import com.dbs.repo.CustomerRepo;
import com.dbs.repo.TransactionRepo;
import com.dbs.utils.Permutation;
import com.dbs.utils.TransferType;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo transRepo;

	@Autowired
	BankBicService bankBicService;

	@Autowired
	CustomerService custService;

	@Autowired
	CustomerRepo custRepo;

	@Autowired
	MessageCodesService msgService;

	public Transaction saveTransaction(TransactionRequestDto trans) {
		String transferType = trans.getTransferType();
		String receiverName = trans.getReceiverName().strip().toUpperCase();
		Customer cust = custService.getCustomerByAcctNumber(trans.getSenderAcctNumber());
		String custName = cust.getName();

		System.out.println(trans);
		
		// validate transferType field
		if(!transferType.equals("BANK") && !transferType.equals("CUSTOMER")) {
			throw new TransactionNotValidException("The transfer type is not recognizable");
		}
		if ((transferType.equals("BANK")
				&& (!receiverName.startsWith("HDFC BANK") || !custName.startsWith("HDFC BANK")))
				|| (transferType.equals("CUSTOMER")
						&& (receiverName.startsWith("HDFC BANK") || custName.startsWith("HDFC BANK")))) {
			throw new TransactionNotValidException("The transfer type has been set incorrectly");
		}

		if (trans.getAmount().equals(0)) {
			throw new TransactionNotValidException("Amount should be greater than zero");
		}

		Double amount = trans.getAmount();
		Double transFee = amount * 0.0025;

		cust = custService.getCustomerByAcctNumber(trans.getSenderAcctNumber());
		Double custAcctBalance = cust.getClearBalance();

		if ((amount + transFee) > custAcctBalance && cust.getOverdraft().equals("NO")) {
			throw new TransactionNotValidException(
					"The sender doesn't have enough amount to complete the transaction.");
		}

		try {
			if (isReceiverInSdnList(trans.getReceiverName())) {
				throw new TransactionNotValidException(
						"The receiver is in SDN list, the transaction cannot be processed");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Transaction transaction = new Transaction();
		transaction.setMessageCode(msgService.findById(trans.getMessageCode().strip()));
		transaction.setReceiverAccountNumber(trans.getReceiverAcctNumber().strip());
		transaction.setReceiverBic(bankBicService.getBankDetailsByBic(trans.getReceiverBic().strip()));
		transaction.setReceiverName(trans.getReceiverName().strip());
		transaction.setTimestamp(new Date());
		transaction.setAmount(amount);
		transaction.setTransferType(trans.getTransferType().equals("BANK") ? TransferType.BANK : TransferType.CUSTOMER);
		cust.setClearBalance(custAcctBalance - (amount + transFee));
		custRepo.save(cust);

		transaction.setCustomer(custService.getCustomerByAcctNumber(cust.getAccountNumber()));
		transaction = transRepo.save(transaction);

		return transaction;

	}
	
	public Page<Transaction> getTransactionsBetween(String _startDate,String _endDate,int page,int size){
		Date startDate=null;
		Date endDate=null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(_startDate);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(_endDate);
			
			// add 23hrs 59 minutes 59 seconds to the end date.
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(endDate);
		    calendar.add(Calendar.HOUR_OF_DAY, 23);
		    calendar.add(Calendar.MINUTE, 59);
		    calendar.add(Calendar.SECOND, 59);
		    endDate = calendar.getTime();
			
		} catch (ParseException e) {
			
		}
		Page<Transaction> pageRes = transRepo.findByTimestampBetween(startDate, endDate,PageRequest.of(page, size));
		return pageRes;
	}

	private boolean isReceiverInSdnList(String name) throws FileNotFoundException {
		String[] l = name.strip().split(" ");

		List<String> permList = Permutation.findPermutations(l, ' ');
		String regexp = String.join("|", permList);
		File file = ResourceUtils.getFile("classpath:sdnlist.txt");

		Scanner fileScanner = new Scanner(file);

		boolean matchFound = false;

		Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = null;
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			matcher = pattern.matcher(line);
			if (matcher.find()) {
				matchFound = true;
				break;
			}
		}

		return matchFound;
	}

}
