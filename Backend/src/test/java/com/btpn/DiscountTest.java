//package com.btpn;
//
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Matchers.anyInt;
//import static org.mockito.Mockito.when;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import com.btpn.sale.service.Discount;
//import com.btpn.persistence.entity.service.UserDAO;
//import com.btpn.persistence.user.User;
//import com.btpn.persistence.user.UserService;
//
//
//public class DiscountTest {
//	
//	@Mock
//	UserService userService;
//	
//	@InjectMocks
//	private Discount discount;
//
//	User employee;
//	User affiliate;
//	
//	@Before
//	public void setup() {
//        MockitoAnnotations.initMocks(this);
//        
//    	try {
//    		// instantiate user
//	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			employee = new User(1, "Irvan Febrianto", User.USER_TYPE_EMPLOYEE, sdf.parse("2011-01-11"));
//			affiliate = new User(2, "Ariana Grande", User.USER_TYPE_AFFILIATE,  sdf.parse("2016-11-30"));
//			discount = new Discount(userService);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void userTypeDiscountTest() {
//		
//		double empDisc = discount.discountByUserTypeOnPercentage(employee);
//		assertTrue(empDisc == 30);
//		
//		double affDisc = discount.discountByUserTypeOnPercentage(affiliate);
//		assertTrue(affDisc == 15);
//	}
//	
//	@Test
//	public void overTwoYearsDiscountTest() {
//		
//		double empYearDisc = discount.discountByYearsNumOnPercentage(employee);
//		assertTrue(empYearDisc == 5.0);
//		
//		double affYearDisc = discount.discountByYearsNumOnPercentage(affiliate);
//		assertTrue(affYearDisc == 0.0);
//	}
//	
//	@Test
//	public void discountByTheBillTest() {
//		
//		double discountBill = discount.discountByHundredBillsOnDollars(100);
//		assertTrue(discountBill == 5);
//	}
//	
////	@Test
////	public void netPayableAmountTest() {
////		when(userService.findByUserId(1)).thenReturn(employee);
////		when(userService.findByUserId(2)).thenReturn(affiliate);
////		System.out.println(employee.getNetAmount());
////		
//////		double employeGroceriesNetAmount = userService.findByUserId(1).getTotalValue();
//////		System.out.println(employeGroceriesNetAmount);
//////		assertTrue(employeGroceriesNetAmount == 1800);
////		
//////		double employeNonGroceriesNetAmount = discount.netPayableAmount(1, true);
//////		assertTrue(employeNonGroceriesNetAmount == 2850);
//////		
//////		
//////		double affiliateGroiceriesNetAmount = discount.netPayableAmount(2, true);
//////		assertTrue(affiliateGroiceriesNetAmount == 3800);
//////		
//////		double affiliateNonGroiceriesNetAmount = discount.netPayableAmount(2, false);
//////		assertTrue(affiliateNonGroiceriesNetAmount == 3200);
////		
////	}
//
//}