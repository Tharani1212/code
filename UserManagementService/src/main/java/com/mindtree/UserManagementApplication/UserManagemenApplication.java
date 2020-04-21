package com.mindtree.UserManagementApplication;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.xmlpull.v1.XmlPullParserException;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.mindtree.*"})
@EnableJpaRepositories(basePackages = {"com.mindtree.*"})
@EntityScan("com.mindtree.*")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class UserManagemenApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagemenApplication.class, args);
	}
	
	 @Bean
	   public RestTemplate restTemplate(RestTemplateBuilder builder) {
	      return builder.build();
	   }
	 
	 @Bean
	 UiConfiguration uiConfig() {
	     return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
	             UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	 }
	
	
}
