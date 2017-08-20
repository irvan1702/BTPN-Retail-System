package com.btpn.persistence.transaction;

import com.btpn.persistence.item.Item;
import com.btpn.persistence.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
    @Column(name="transaction_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer transactionId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item itemId;

    @Column(name="quantity")
    private Integer quantity;

	@Column(name="transaction_date", nullable=false)
	private Date transactionDate;

    @Column(name="total_price", nullable=false)
	private Double totalPrice;
	
	@Column(name="discount")
	private Double discount;

	@Column(name="grand_total", nullable=false)
	private Double grandTotal;



    public Transaction() {
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTransactionId() {
        return transactionId;

    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

	public Integer getId() {

	    return transactionId;
	}

	public void setId(Integer transactionId) {

	    this.transactionId = transactionId;
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
}