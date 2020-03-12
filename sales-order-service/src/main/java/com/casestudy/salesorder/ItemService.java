package com.casestudy.salesorder;


import org.springframework.web.client.RestTemplate;


public class ItemService {
	
	//http://item-service-app-cicd.169-61-227-230.nip.io/items
	
	
	public static Item getItemByName( String itemName) {
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://item-service-app-cicd.169-61-227-230.nip.io/items/";
		
		Item item = restTemplate.getForObject(baseUrl+itemName,Item.class);
		
		return item;
	}

}
