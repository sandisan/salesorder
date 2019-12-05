package com.casestudy.salesorder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="sales-order-service-491968")
@Component
public class SalesOrderConfig {

	private String fallbackmessage;

	public String getFallbackmessage() {
		return fallbackmessage;
	}

	public void setFallbackmessage(String fallbackmessage) {
		this.fallbackmessage = fallbackmessage;
	}
}
