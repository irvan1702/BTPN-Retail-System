package com.btpn.persistence.transaction;

import java.util.List;

import org.springframework.stereotype.Component;

import com.btpn.persistence.item.*;

@Component
public interface TransactionService {
	
	List<Transaction> getAllTransaction();
	
	Transaction findTransactionById(Integer transactionId);
	
	public void insertTransaction(Transaction item);

	public void updateTransaction(Transaction item);

	public void deleteTransaction(Integer transactionId);
	
}
