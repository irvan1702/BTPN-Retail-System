package com.btpn.persistence.transaction;

import com.btpn.persistence.item.Item;
import com.btpn.persistence.item.ItemService;
import com.btpn.persistence.user.User;
import com.btpn.persistence.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Repository
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDAO transactionRepository;

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    Double totalDiscount;

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

    @Override
    public double discountByUserTypeOnPercentage(User user) {
        double discountVal = 0.0;

        if(user.getUserType().equalsIgnoreCase("Employee")){
            discountVal = 30;
        }
        else if(user.getUserType().equalsIgnoreCase(("Affilate"))){
            discountVal = 15;

        }
        else{
            discountVal = 0;
        }
		return discountVal;
    }

    @Override
    public double discountByYearsNumOnPercentage(User user) {
        double discountVal = 0.0;

		if (user != null && isMoreThan2Years(user.getJoinDate())) {
			discountVal = 5;
		}
		return discountVal;
    }

    @Override
    public boolean isMoreThan2Years(Date compareDate) {
        LocalDate currentDate = LocalDate.now();
		Date twoYearsDate = Date.from(currentDate.minusYears(2).atStartOfDay(ZoneId.systemDefault()).toInstant());
		return twoYearsDate.compareTo(compareDate) == 1;
    }

    @Override
    public double discountByHundredBillsOnDollars(double paidBills) {
        double discountVal = 0.0;
//
		if (paidBills >= 100) {
			discountVal = ((paidBills - (paidBills%100))/100) * 5;
		}
		return discountVal;
    }


    @Override
    public Double netPayableAmount(Integer userId, Integer itemId, Double quantity) {
        User user = userService.findUserById(userId);
        Item item = itemService.findItemById(itemId);

		double percentDiscount = 0.0;

		if ( userId != null && !item.getItemType().equalsIgnoreCase("Groceries")){
			percentDiscount = discountByUserTypeOnPercentage(user);
			percentDiscount += discountByYearsNumOnPercentage(user);
		}
		else if(item.getItemType().equalsIgnoreCase("Groceries")) {
//			user.setDiscountValue(0);
//			userService.saveUser(user);
            percentDiscount = 0.0;
		}
		this.totalDiscount = percentDiscount;
        double totalPrice = item.getItemPrice()*quantity;
		double netAmount = percentDiscount > 0.0 ? totalPrice - ((percentDiscount*totalPrice)/100) : totalPrice;
		Double result =  netAmount - discountByHundredBillsOnDollars(netAmount);
		return result;
    }

    @Override
    public Double getTotalDiscount(){
        return totalDiscount;
    }

    @Override
    public Double totalPayment(Double avaiableMoney, Transaction[] transactions){
	    Double transactionTotal = 0.0;
	    for(int i = 0;i<transactions.length;i++){
	        transactionTotal+=transactions[i].getGrandTotal();
        }
        return avaiableMoney - transactionTotal;
    }
}
