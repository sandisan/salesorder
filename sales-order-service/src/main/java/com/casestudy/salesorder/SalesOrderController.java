package com.casestudy.salesorder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class SalesOrderController {

	@Autowired
	private SalesOrderRepository salesOrderRepository;
	
	@Autowired
	private OrderLineItemRepository orderLineItemRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//@Autowired
	//ItemService itemService;

	//@Autowired
	//SalesOrderConfig salesOrderConfig;
	
	
	@PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod="fallback")
	public Response<Long> saveCustomer(@RequestBody SalesOrderRequest salesOrderRequest) {
		 
		Response<Long> response = new Response<>();
		SalesOrder salesOrder = salesOrderRequest.getSalesOrder();
		// Validate Customer
		CustomerSOS customerSos = customerRepository.findOne(salesOrder.getCustId());
		if (customerSos ==  null) {
			response.setIsError(true);
			response.setMessage("Customer not found");
			return response;
		}
		System.out.println(customerSos.getFirstName());
		
		List<OrderLineItem> lineItems = salesOrderRequest.getOrderLineItem();
		// Validate Item
		Iterator<OrderLineItem> itemIterator = lineItems.iterator();
		boolean hasAllItems = true;
		while (itemIterator.hasNext()) {
			String itemName = itemIterator.next().getItemName();
			Item item = ItemService.getItemByName(itemName);
			System.out.println(itemName +" : "+item.getItemName());
			if (item.getItemName()== null){
				hasAllItems = false;
			}
		}
		if (hasAllItems == false) {
			response.setIsError(true);
			response.setMessage("Items not valid");
			return response;
		}
		
//		lineItems.forEach((temp) -> {		
//		});
		// save salesorder
		SalesOrder order = salesOrderRepository.save(salesOrder);
		// update orderid and and save orderitemlist
		lineItems.stream().forEach(e -> e.setOrderId(order.getOrderId()));
		// .stream().map(e -> e.setOrderId(order.getOrderId()));
		 orderLineItemRepository.save(lineItems);
		 response.setIsError(false);
		 response.setMessage("Success");
		 response.setOrderId(order.getOrderId());
		 return response;
				 
	}
	
	@GetMapping("/order/list")
	public SalesOrderRequest getOrder() {
		
		SalesOrderRequest sor = new SalesOrderRequest();
		SalesOrder so = new SalesOrder();
		so.setCustId(101L);
		so.setOrderDate("11-29-2019");
		so.setOrderDesc("desc");
		so.setTotalPrice(100.10F);
		sor.setSalesOrder(so);
		List <OrderLineItem> olt = new ArrayList<OrderLineItem>();
		OrderLineItem lt = new OrderLineItem();
		lt.setItemId(202L);
		lt.setItemName("name");
		lt.setItemQty("10");
		olt.add(lt);
		sor.setOrderLineItem(olt);
		return sor;
	}
		
	public Response<Long> fallback(SalesOrderRequest salesOrderRequest) {
		Response<Long> response = new Response<>();
		response.setIsError(true);
		response.setMessage("Unable To Process Order Request");
		return response ;
	}
	
    @CrossOrigin(origins = "*")
    @GetMapping("/heartbeat")
    @ResponseBody
    public String getHeartBeat(){
         return "success";
    }
}
