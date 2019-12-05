package com.casestudy.salesorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//id, order_date, cust_id, order_desc, total_price
@Entity(name = "sales_order")
public class SalesOrder {

	@Id
	@GeneratedValue
	@Column(name="order_id")
	private Long orderId;
	@Column(name="customer_id")
	private Long custId;
	@Column(name="order_date")
	private String orderDate;
	@Column(name="order_desc")
	private String orderDesc;
	@Column(name="total_price")
	private Float totalPrice;

	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
}
