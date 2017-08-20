package com.btpn.persistence.transaction;

import com.btpn.persistence.user.User;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TransactionService {
	
	List<Transaction> getAllTransaction();
	
	Transaction findTransactionById(Integer transactionId);
	
	public void insertTransaction(Transaction item);

	public void updateTransaction(Transaction item);

	public void deleteTransaction(Integer transactionId);

	public double discountByUserTypeOnPercentage(User user);

	public double discountByYearsNumOnPercentage(User user);

	public boolean isMoreThan2Years(Date compareDate);

	public double discountByHundredBillsOnDollars(double paidBill);

	public Double getTotalDiscount();

	public Double netPayableAmount(Integer userId, Integer itemId, Double quantity);

	public Double totalPayment(Double avaiableMoney, Transaction[]transactions);


	
}
