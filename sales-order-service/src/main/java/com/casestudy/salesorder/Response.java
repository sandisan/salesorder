package com.casestudy.salesorder;

public class Response<T> {
	
	private String message;
	private Boolean isError;
	private T orderId;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getIsError() {
		return isError;
	}
	public void setIsError(Boolean isError) {
		this.isError = isError;
	}
	public T getOrderId() {
		return orderId;
	}
	public void setOrderId(T orderId) {
		this.orderId = orderId;
	}
	
}
