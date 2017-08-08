package com.btpn.persistence.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User implements Serializable {
	
	/**
	 * Default serial version ID for user class
	 */
	private static final long serialVersionUID = 1L;
	public static final String USER_TYPE_EMPLOYEE = "E";
	public static final String USER_TYPE_AFFILIATE = "A";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="join_date")
	private Date joinDate;
	
	@Column(name="net_amount")
	private double netAmount;
	
	@Column(name="discount_value")
	private double discountValue;
	
	@Column(name="total_value")
	private double totalValue;
	
	@Column(name="is_groceries")
	private boolean isGroceries;
	
	public User() {};
	
	public User(Integer userId, String userName, String userType, Date joinDate) {
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.joinDate = joinDate;
	}
	
	public User(String userId, String userName, String userType, String joinDate) {
		try {
			this.userId = Integer.parseInt(userId);
			this.userName = userName;
			this.userType = userType;
			this.joinDate = sdf.parse(joinDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public boolean getIsGroceries() {
		return isGroceries;
	}

	public void setIsGroceries(boolean isGroceries) {
		this.isGroceries = isGroceries;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", joinDate=" + joinDate
				+ ", netAmount=" + netAmount + ", discountValue=" + discountValue + ", totalValue=" + totalValue + "]";
	}

//	@Override
//	public String toString() {
//		return "User : {userId:" + userId + ", userName:" + userName + ", userType:" + userType + ", joinDate:" + joinDate
//				+ "}";
//	}
	
	
	
}
