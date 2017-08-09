package com.btpn.persistence.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.btpn.persistence.item.Item;

@Service
@Repository
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDAO transactionRepository;

	@Override
	public List<Transaction> getAllTransaction() {
		List<Transaction> listTransaction = new ArrayList<Transaction>();
		transactionRepository.findAll().forEach(listTransaction::add);
		return listTransaction;
	}

	@Override
	public Transaction findTransactionById(Integer transactionId) {
		return transactionRepository.findOne(transactionId);
	}

	@Override
	public void insertTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
		
	}

	@Override
	public void deleteTransaction(Integer transactionId) {
		transactionRepository.delete(transactionId);
		
	}
	
	
}
