package com.btpn.persistence.transaction;

import java.util.Date;

import javax.persistence.*;

import com.btpn.persistence.user.User;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
    @Column(name="transaction_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@Column(name="transaction_date", nullable=false)
	private Date transactionDate;
	
	@Column(name="total_price", nullable=false)
	private Double totalPrice;
	
	@Column(name="discount")
	private Double discount;
	
	@Column(name="grand_total", nullable=false)
	private Double grandTotal;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}