package com.mindtree.FoodOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.mindtree.Filters.ErrorFilter;
import com.mindtree.Filters.PostFilter;
import com.mindtree.Filters.PreFilter;
import com.mindtree.Filters.RouteFilter;



@EnableZuulProxy
@SpringBootApplication
public class FoodOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderApplication.class, args);
	}
	
	

}
