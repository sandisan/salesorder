package com.casestudy.salesorder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//id, item_name, item_quantity, order_id
@Entity(name = "order_line_item")
public class OrderLineItem {

	@Id
	@GeneratedValue
	private Long itemId;
	private String itemName;
	private String itemQty;
	private Long orderId;
	
	public Long getOrderId() {
		return orderId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemQty() {
		return itemQty;
	}
	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
}
