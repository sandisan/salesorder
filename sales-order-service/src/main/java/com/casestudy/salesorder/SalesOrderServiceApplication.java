package com.casestudy.salesorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

//@EnableDiscoveryClient
@EnableFeignClients("com.casestudy.salesorder")
@SpringBootApplication
@EnableCircuitBreaker
public class SalesOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderServiceApplication.class, args);
	}

}
