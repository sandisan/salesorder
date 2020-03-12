package com.casestudy.salesorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

//@EnableDiscoveryClient
//@EnableFeignClients("com.casestudy.salesorder")
@SpringBootApplication
@EnableCircuitBreaker
public class SalesOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderServiceApplication.class, args);
	}

}
