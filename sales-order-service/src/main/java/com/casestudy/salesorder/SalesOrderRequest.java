package com.casestudy.salesorder;

import java.util.List;

public class SalesOrderRequest {

	private SalesOrder salesOrder;
	private List<OrderLineItem> orderLineItem;
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}
	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}
	public List<OrderLineItem> getOrderLineItem() {
		return orderLineItem;
	}
	public void setOrderLineItem(List<OrderLineItem> orderLineItem) {
		this.orderLineItem = orderLineItem;
	}
		
}
