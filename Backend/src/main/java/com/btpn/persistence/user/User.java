package com.btpn.persistence.user;

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
	
	//@Column(name="user_name")
	private String userName;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="join_date")
	private Date joinDate;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	public User() {}
	
	public User(Integer userId, String username, String userType, Date joinDate, String name, String password) {
		super();
		this.userId = userId;
		this.userName = username;
		this.userType = userType;
		this.joinDate = joinDate;
		this.name = name;
		this.password = password;
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

	public void setUserName(String username) {
		this.userName = username;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userType=" + userType + ", joinDate=" + joinDate
				+ ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
}
