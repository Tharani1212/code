package com.mindtree.OrderManagementApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;






@SpringBootApplication(scanBasePackages = {"com.mindtree.*"})
@EnableJpaRepositories(basePackages = {"com.mindtree.*"})
@EntityScan("com.mindtree.*")
@EnableDiscoveryClient
public class OrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

}
