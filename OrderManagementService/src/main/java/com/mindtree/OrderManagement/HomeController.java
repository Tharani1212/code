package com.mindtree.OrderManagement;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mindtree.OrderService.OrderService;
import com.mindtree.OrderEntity.Cart;

@RestController
public class HomeController {
	@Autowired
	OrderService orderService;
	
	@Autowired
   private KafkaTemplate<String, String> kafkaTemplate;
	
	
	
	private  static  final String Topic="order";
	
	
	private  static  final String Topic1="place";
   
	 @PostMapping(value = "/Add")
	    public ResponseEntity<Cart>  addTocart(@RequestBody Cart data) {
		  
		  Cart res = orderService.addTocart(data);
		 
		  kafkaTemplate.send(Topic,"Added to cart successfully of order Id "+data.getOrderId());
	        return new ResponseEntity<Cart>(res,HttpStatus.OK);
	    }
	 
	@GetMapping(value="/orderdetails/{uId}")
	public ResponseEntity<ArrayList<String>>  orderit(@PathVariable("uId")  Integer uId) {
		 
		ArrayList<String> res = orderService.order(uId);
		 kafkaTemplate.send(Topic1,"order Placed Successfully "+uId);
	      
	        return new ResponseEntity<ArrayList<String>>(res,HttpStatus.OK);
	    }
	 
	 
}
