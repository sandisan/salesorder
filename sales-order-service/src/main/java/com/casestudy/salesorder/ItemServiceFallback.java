package com.casestudy.salesorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemServiceFallback implements ItemService {

	@Autowired
	SalesOrderConfig salesOrderConfig;
	@Override
	public Item getItemByName(String itemName) {
		// TODO Auto-generated method stub
		System.out.println("Falling back");
		Item itm = new Item();
		itm.setId(999L);
		itm.setName("default name");
		itm.setDescription(salesOrderConfig.getFallbackmessage());
		itm.setPrice("9999");
		return itm ;
	}
	

}
