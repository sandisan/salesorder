package com.casestudy.salesorder;

import java.io.Serializable;

import javax.persistence.Id;

public class Item implements Serializable {
	
	private static final long serialVersionUID = -7788619177798333712L;

	private long itemId;
	private String itemName;
	private String itemDesc;
	private String iemPrice;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public String getIemPrice() {
		return iemPrice;
	}
	public void setIemPrice(String iemPrice) {
		this.iemPrice = iemPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
