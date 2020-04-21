package com.mindtree.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.OrderEntity.Cart;
import com.mindtree.OrderRepository.OrderRepository;
import com.mindtree.OrderService.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	
	


	@Override
	public Cart addTocart(Cart data) {
		// TODO Auto-generated method stub
		return orderRepository.orderit(data);
	}





	@Override
	public ArrayList<String> order(Integer uId) {
		// TODO Auto-generated method stub
		return orderRepository.order(uId);
	}


}
