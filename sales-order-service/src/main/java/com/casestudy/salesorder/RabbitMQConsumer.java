package com.casestudy.salesorder;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class RabbitMQConsumer {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@RabbitListener(queues = "${customer.rabbitmq.queue}")
	public void recievedMessage(CustomerSOS customer) {
		System.out.println("Recieved Message From RabbitMQ: "+customer);
		CustomerSOS addedCustomer = customerRepository.save(customer);
		System.out.println("Customer Record Saved !!!! ");
//		System.out.println("CustomerId: " + customer.getCustId());
//		System.out.println("CustomerFirstName: " + customer.getCustFirstName());
//		System.out.println("CustomerLastName: " + customer.getCustLastName());
//		System.out.println("CustomerEmail: " + customer.getCustEmail());
	}
}