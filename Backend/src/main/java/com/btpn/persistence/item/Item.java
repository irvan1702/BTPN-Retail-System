package com.btpn.persistence.item;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="item")
public class Item implements Serializable {

	/**
	 * Default serial version ID for user class
	 */
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Integer itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_type")
	private String itemType;
	
	@Column(name="item_price")
	private Double itemPrice;
	
	@Column(name="item_count")
	private Integer itemCount;
	
	public Item() {}
	
	public Item(Integer itemId, String itemName, String itemType, Double itemPrice, Integer itemCount) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.itemCount = itemCount;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getItemCount() {
		return itemCount;
	}

	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice="
				+ itemPrice + ", itemCount=" + itemCount + "]";
	};
	
	
	
	
	
}
