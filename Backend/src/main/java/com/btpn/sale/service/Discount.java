package com.btpn.sale.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btpn.persistence.entity.User;
import com.btpn.user.UserService;

@Service
public class Discount {
	
	@Autowired
	private UserService userService;

	public Discount() {};
	
	public Discount(UserService userService) {
		this.userService = userService;
	}
	
	
	public double discountByUserTypeOnPercentage(User user) {
		double discountVal = 0.0;
		
		switch (user.getUserType()) {
		case User.USER_TYPE_EMPLOYEE:
			discountVal = 30;
			break;

		case User.USER_TYPE_AFFILIATE:
			discountVal = 15;
			break;
			
		default:
			break;
		}
		return discountVal;
	}

	
	public double discountByYearsNumOnPercentage(User user) {
		double discountVal = 0.0;
		
		if (user != null && isMoreThan2Years(user.getJoinDate())) {
			discountVal = 5;
		} 
		return discountVal;
	}
	
	private boolean isMoreThan2Years(Date compareDate) {
		LocalDate currentDate = LocalDate.now();
		Date twoYearsDate = Date.from(currentDate.minusYears(2).atStartOfDay(ZoneId.systemDefault()).toInstant());
		return twoYearsDate.compareTo(compareDate) == 1;
	}

	
	public double discountByHundredBillsOnDollars(double paidBills) {
		double discountVal = 0.0;
		
		if (paidBills >= 100) {
			discountVal = ((paidBills - (paidBills%100))/100) * 5;
		}
		return discountVal;
	}
	
	
	public double netPayableAmount(Integer userId, boolean isGroceries) {
		User user = userService.findByUserId(userId);
		
		
		if (user == null) {
			List<User> userList = userService.findAllUser();
			for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
				User us = iterator.next();
				if (userId == us.getUserId()) {
					user = us;
				}
			}
		}
		
		double percentDiscount = 0.0;
		double chargedBill = user.getNetAmount();
		
		if ( user != null && !isGroceries) {
			percentDiscount = discountByUserTypeOnPercentage(user);
			percentDiscount += discountByYearsNumOnPercentage(user);
			user.setDiscountValue(percentDiscount);
			userService.saveUser(user);
		}
		else if(isGroceries) {
			user.setDiscountValue(0);
			userService.saveUser(user);
		}
		
		double netAmount = percentDiscount > 0.0 ? chargedBill - ((percentDiscount*chargedBill)/100) : chargedBill;
		double result =  netAmount - discountByHundredBillsOnDollars(chargedBill);
		user.setTotalValue(result);
		user.setIsGroceries(isGroceries);
		userService.saveUser(user);
		return result;
	}
	
}
